package com.zenika.story.adventure.presentation.montreal.library

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
import com.zenika.story.adventure.presentation.component.AdventureInventoryBag
import com.zenika.story.adventure.presentation.component.ContinentsMap
import com.zenika.story.adventure.presentation.montreal.component.MontrealScaffoldScreen
import com.zenika.theme.ScreenPreview
import kotlin.math.roundToInt

@Composable
fun LibraryScreen(
    remainingTime: Int,
    newItem: Boolean,
    goBack: () -> Unit,
    goToSettings: () -> Unit,
    goToRooftop: () -> Unit,
    openWorldMap: () -> Unit,
    openInventory: () -> Unit,
    modifier: Modifier = Modifier
) {
    var offsetX by remember { mutableStateOf(0f) }
    val screenWidth = LocalConfiguration.current.screenWidthDp

    MontrealScaffoldScreen(
        remainingTime = remainingTime,
        goBack = goBack,
        goToSettings = goToSettings,
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
            openInventory = openInventory,
            newItem = newItem,
            modifier = Modifier
                .size(80.dp)
                .align(Alignment.BottomEnd)
        )
    }
}

@ScreenPreview
@Composable
private fun LibraryScreenPreview() {
    LibraryScreen(
        remainingTime = 0,
        newItem = false,
        goBack = {},
        goToSettings = {},
        goToRooftop = {},
        openWorldMap = {},
        openInventory = {}
    )
}
