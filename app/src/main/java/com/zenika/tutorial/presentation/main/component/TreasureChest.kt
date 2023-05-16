package com.zenika.tutorial.presentation.main.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.zenika.R
import com.zenika.utils.ComposablePreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun TreasureChest(
    chestState: Boolean,
    collectedMap: Boolean,
    openMiniGame: () -> Unit,
    getMap: () -> Unit
) {
    if (!chestState) {
        Chest(R.mipmap.closed_chest, openMiniGame)
    } else if (!collectedMap) {
        Chest(R.mipmap.map_chest, getMap)
    } else {
        Chest(R.mipmap.open_chest) {}
    }
}

@Composable
private fun Chest(
    chest: Int,
    onClick: () -> Unit
) {
    Image(
        painter = painterResource(
            id = chest
        ),
        contentDescription = "Treasure chest",
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .padding(start = 0.dp, top = 400.dp, end = 0.dp, bottom = 0.dp)
            .clickable {
                onClick()
            }
    )
}

@ComposablePreview
@Composable
fun TreasureChestPreview() {
    ZEscapeThemePreview {
        TreasureChest(
            chestState = true,
            collectedMap = false,
            openMiniGame = {},
            getMap = {}
        )
    }
}