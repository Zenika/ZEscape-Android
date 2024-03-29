package com.zenika.story.tutorial.presentation.main.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.unit.dp
import com.zenika.R
import com.zenika.theme.ComposablePreview
import com.zenika.theme.ZEscapeThemePreview

@Composable
fun TreasureChest(
    chestOpened: Boolean,
    mapCollected: Boolean,
    openMiniGame: () -> Unit,
    collectMap: () -> Unit
) {
    if (!chestOpened) {
        Chest(R.mipmap.closed_chest, onClick = openMiniGame)
    } else if (!mapCollected) {
        Chest(R.mipmap.map_chest, onClick = collectMap)
    } else {
        Chest(R.mipmap.open_chest, onClick = {})
    }
}

@Composable
private fun Chest(
    @DrawableRes
    chestDrawable: Int,
    onClick: () -> Unit
) {
    val closeChestState = stringResource(R.string.close_treasure_chest)
    val mapChestState = stringResource(R.string.open_map_treasure_chest)
    val openChestState = stringResource(R.string.open_treasure_chest)

    Image(
        painter = painterResource(chestDrawable),
        contentDescription = stringResource(R.string.treasure_chest),
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .padding(top = 400.dp)
            .clickable(onClick = onClick)
            .semantics {
                stateDescription =
                    when (chestDrawable) {
                        R.mipmap.closed_chest -> closeChestState
                        R.mipmap.map_chest -> mapChestState
                        else -> openChestState
                    }
            }
    )
}

@ComposablePreview
@Composable
private fun TreasureChestPreview() {
    ZEscapeThemePreview {
        TreasureChest(
            chestOpened = false,
            mapCollected = false,
            openMiniGame = {},
            collectMap = {})
    }
}
