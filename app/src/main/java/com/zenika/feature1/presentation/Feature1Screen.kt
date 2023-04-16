package com.zenika.feature1.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
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
import com.zenika.feature1.presentation.component.Count
import com.zenika.feature1.presentation.component.Feature1BottomBar
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Feature1Screen(
    modifier: Modifier,
    state: Feature1State,
    onIncrement: () -> Unit,
    goToFeature2: () -> Unit
) {
    Scaffold(
        modifier = modifier,
        contentWindowInsets = WindowInsets.navigationBars,
        topBar = {
            Box(
                Modifier
                    .background(MaterialTheme.colorScheme.primary)
                    .statusBarsPadding()
                    .fillMaxWidth()
            )
        },
        bottomBar = {
            Feature1BottomBar(
                modifier = Modifier.fillMaxWidth(),
                onIncrement = onIncrement,
                onGoToNext = goToFeature2
            )
        }
    ) { paddingValues ->
        Box(
            Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Count(
                state.count,
                Modifier.align(Alignment.Center)
            )
        }
    }
}

@ScreenPreview
@Composable
fun Feature1ScreenPreview() {
    ZEscapeThemePreview {
        Feature1Screen(
            Modifier.fillMaxSize(),
            state = Feature1State(13),
            onIncrement = {},
            goToFeature2 = {}
        )
    }
}
