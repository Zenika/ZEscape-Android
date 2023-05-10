package com.zenika.tutorial.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.zenika.R
import com.zenika.tutorial.domain.GameViewModel
import com.zenika.tutorial.presentation.component.TreasureChest
import com.zenika.tutorial.presentation.component.inventory.Inventory
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TutorialScreen(
    modifier: Modifier,
    viewModel: GameViewModel,
    openMiniGame: () -> Unit,
    openInventory: () -> Unit,
    getMap: () -> Unit
) {
    Scaffold(modifier = modifier,
        topBar = {
            Box(
                Modifier
                    .fillMaxWidth()
            )
        }
    ) {
        Box(
            Modifier
                .fillMaxSize()
                .paint(
                    painterResource(id = R.mipmap.sea_background),
                    contentScale = ContentScale.FillHeight
                ),
            contentAlignment = Alignment.Center
        ) {
            TreasureChest(
                viewModel,
                openMiniGame,
                getMap
            )
        }
        Box(
            Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.BottomEnd
        ) {
            Inventory(
                openInventory
            )
        }
    }
}

@ScreenPreview
@Composable
fun TutorialScreenPreview() {
    ZEscapeThemePreview {
        TutorialScreen(
            Modifier
                .fillMaxSize(),
            viewModel = GameViewModel(),
            openMiniGame = {},
            openInventory = {},
            getMap = {}
        )
    }
}
