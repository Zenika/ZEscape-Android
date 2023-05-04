package com.zenika.tutorial.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.zenika.R
import com.zenika.tutorial.presentation.component.Code
import com.zenika.tutorial.presentation.component.TreasureChest
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TutorialScreen(
    modifier: Modifier,
    viewModel: TutorialViewModel,
    openMiniGame: () -> Unit,
    getMap: () -> Unit
) {
    Scaffold(modifier = modifier, contentWindowInsets = WindowInsets.navigationBars, topBar = {
        Box(
            Modifier
                .background(MaterialTheme.colorScheme.primary)
                .statusBarsPadding()
                .fillMaxWidth()
        )
    }) { paddingValues ->
        Box(
            Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .paint(
                    painterResource(id = R.mipmap.sea_background),
                    contentScale = ContentScale.FillHeight
                )
        ) {
            Column(
                Modifier
                    .align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Code()
                TreasureChest(
                    viewModel,
                    openMiniGame,
                    getMap
                )
            }
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
            viewModel = TutorialViewModel(),
            openMiniGame = {},
            getMap = {}
        )
    }
}
