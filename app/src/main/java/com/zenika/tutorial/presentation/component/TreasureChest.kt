package com.zenika.tutorial.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.zenika.R
import com.zenika.tutorial.presentation.TutorialViewModel
import com.zenika.utils.ComposablePreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun TreasureChest(
    viewModel: TutorialViewModel,
    openMiniGame: () -> Unit,
    getMap: () -> Unit
) {
    val chestState by viewModel.chestState.collectAsState()
    val collectedMap by viewModel.collectedMap.collectAsState()

    if (!chestState) {
        Chest(R.mipmap.closed_chest, openMiniGame)
    } else if (!collectedMap) {
        Chest(R.mipmap.map_chest, getMap)
    } else {
        Chest(R.mipmap.open_chest) {}
    }
}

@Composable
private fun Chest(chest: Int, actionOnClick: () -> Unit) {
    Image(
        painter = painterResource(
            id = chest
        ),
        contentDescription = "Treasure chest",
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .padding(start = 0.dp, top = 400.dp, end = 0.dp, bottom = 0.dp)
            .clickable {
                actionOnClick()
            }
    )
}

@ComposablePreview
@Composable
fun TreasureChestPreview() {
    ZEscapeThemePreview {
        TreasureChest(
            viewModel = TutorialViewModel(),
            openMiniGame = {},
            getMap = {}
        )
    }
}