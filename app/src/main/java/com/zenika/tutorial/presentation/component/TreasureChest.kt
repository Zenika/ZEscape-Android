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
    openMiniGame: () -> Unit
) {
    val chestState by viewModel.chestState.collectAsState()
    val chest = if (chestState) {
        R.mipmap.open_chest
    } else {
        R.mipmap.closed_chest
    }
    Image(
        painter = painterResource(
            id = chest
        ),
        contentDescription = "Treasure chest",
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .padding(start = 0.dp, top = 400.dp, end = 0.dp, bottom = 0.dp)
            .clickable {
                openMiniGame()
            }
    )
}

@ComposablePreview
@Composable
fun TreasureChestPreview() {
    ZEscapeThemePreview {
        TreasureChest(
            viewModel = TutorialViewModel(),
            openMiniGame = {}
        )
    }
}