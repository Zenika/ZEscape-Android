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
import com.zenika.data.state.GameState
import com.zenika.utils.ComposablePreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun TreasureChest(
    gameState: GameState,
    openMiniGame: () -> Unit,
    updateMapState: () -> Unit
) {
    if (!gameState.chestState) {
        Chest(R.mipmap.closed_chest, openMiniGame)
    } else if (!gameState.mapState) {
        Chest(R.mipmap.map_chest, updateMapState)
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
            gameState = GameState(chestState = false, mapState = false),
            openMiniGame = {},
            updateMapState = {}
        )
    }
}