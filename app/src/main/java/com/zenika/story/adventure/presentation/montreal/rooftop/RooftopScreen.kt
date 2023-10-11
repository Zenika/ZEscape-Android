package com.zenika.story.adventure.presentation.montreal.rooftop

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.zenika.R
import com.zenika.common.component.ReturnButton
import com.zenika.common.component.SettingsButton
import com.zenika.common.component.Timer
import com.zenika.story.adventure.presentation.component.AdventureInventoryBag
import com.zenika.story.adventure.presentation.component.ContinentsMap
import com.zenika.theme.ScreenPreview
import com.zenika.theme.screenPadding
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RooftopScreen(
    state: MontrealRooftopUiState,
    goBack: () -> Unit,
    goToSettings: () -> Unit,
    openWorldMap: () -> Unit,
    openInventory: () -> Unit,
    modifier: Modifier = Modifier
) {
    var offsetX by remember { mutableStateOf(0f) }
    val screenWidth = LocalConfiguration.current.screenWidthDp
    var imageWidth by remember { mutableStateOf(0) }
    val minOffset = ((-imageWidth / 2) + (screenWidth * 2)).toFloat()
    val maxOffset = ((imageWidth / 2) - (screenWidth * 2)).toFloat()

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {
                    Timer(state.remainingTime, Modifier.fillMaxWidth())
                },
                navigationIcon = {
                    ReturnButton(goBack = goBack)
                },
                actions = {
                    SettingsButton(goToSettings)
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { paddingValues ->
        Image(
            painter = painterResource(R.mipmap.montreal_rooftop),
            contentDescription = stringResource(R.string.bookshelf),
            modifier = Modifier
                .wrapContentWidth(unbounded = true)
                .fillMaxHeight()
                .offset { IntOffset(offsetX.roundToInt(), 0) }
                .draggable(
                    orientation = Orientation.Horizontal,
                    state = rememberDraggableState { delta ->
                        if (delta < 0 && offsetX > minOffset) offsetX += delta
                        if (delta > 0 && offsetX < maxOffset) offsetX += delta
                    }
                )
                .onGloballyPositioned {
                    imageWidth = it.size.width
                },
            contentScale = ContentScale.FillHeight
        )
        Box(
            Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(screenPadding),
            contentAlignment = Alignment.Center
        ) {

            ContinentsMap(
                modifier = Modifier
                    .size(80.dp)
                    .align(Alignment.BottomStart)
                    .clickable(onClick = openWorldMap)
            )
            AdventureInventoryBag(
                newItem = state.newItem,
                openInventory = openInventory,
                modifier = Modifier
                    .size(80.dp)
                    .align(Alignment.BottomEnd)
            )
        }
    }
}

@ScreenPreview
@Composable
private fun RooftopScreenPreview() {
    RooftopScreen(
        state = MontrealRooftopUiState(newItem = false, remainingTime = 0),
        goBack = {},
        goToSettings = {},
        openWorldMap = {},
        openInventory = {}
    )
}
