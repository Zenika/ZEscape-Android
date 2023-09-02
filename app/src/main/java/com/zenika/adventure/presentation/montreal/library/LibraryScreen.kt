package com.zenika.adventure.presentation.montreal.library

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.zenika.R
import com.zenika.adventure.presentation.component.AdventureInventoryBag
import com.zenika.adventure.presentation.component.ContinentsMap
import com.zenika.adventure.presentation.component.ScaffoldScreen
import com.zenika.data.AdventureHint
import com.zenika.utils.ScreenPreview
import kotlin.math.roundToInt

@Composable
fun LibraryScreen(
    remainingTime: Int,
    goToSettings: () -> Unit,
    goToRooftop: () -> Unit,
    openWorldMap: () -> Unit,
    openInventory: () -> Unit,
    openHintValidation: (AdventureHint) -> Unit,
    modifier: Modifier = Modifier
) {
    var offsetX by remember { mutableStateOf(0f) }
    val screenWidth = LocalConfiguration.current.screenWidthDp

    ScaffoldScreen(
        remainingTime = remainingTime,
        goToSettings = goToSettings,
        openHintValidation = { openHintValidation(AdventureHint.MONTREAL_LIBRARY_HINT) },
        background = R.mipmap.montreal_library,
        modifier = modifier
    ) {
        Button(
            onClick = goToRooftop,
            modifier = Modifier.align(Alignment.Center)
        ) {
            Text(text = stringResource(R.string.rooftop_access))
        }
        Image(
            painter = painterResource(R.mipmap.bookshelf),
            contentDescription = stringResource(R.string.bookshelf),
            modifier = Modifier
                .requiredWidth(screenWidth.dp)
                .align(Alignment.Center)
                .offset { IntOffset(offsetX.roundToInt(), 0) }
                .draggable(
                    orientation = Orientation.Horizontal,
                    state = rememberDraggableState { delta -> offsetX += delta }
                ),
            contentScale = ContentScale.FillWidth
        )
        ContinentsMap(
            modifier = Modifier
                .size(80.dp)
                .align(Alignment.BottomStart)
                .clickable(onClick = openWorldMap)
        )
        AdventureInventoryBag(
            modifier = Modifier
                .size(80.dp)
                .align(Alignment.BottomEnd)
                .clickable(onClick = openInventory)
        )
    }
}

@ScreenPreview
@Composable
private fun LibraryScreenPreview() {
    LibraryScreen(
        remainingTime = 0,
        goToSettings = {},
        goToRooftop = {},
        openWorldMap = {},
        openInventory = {},
        openHintValidation = {}
    )
}
