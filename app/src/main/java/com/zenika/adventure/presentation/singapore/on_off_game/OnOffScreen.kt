package com.zenika.adventure.presentation.singapore.on_off_game

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zenika.R
import com.zenika.adventure.presentation.component.ScaffoldScreen
import com.zenika.ui.theme.FalseButton
import com.zenika.ui.theme.TrueButton
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun OnOffScreen(
    goToSettings: () -> Unit,
    remainingTime: Int,
    buttonsList: List<Boolean>,
    switchColor: (Int) -> Unit
) {
    ScaffoldScreen(
        remainingTime = remainingTime,
        goToSettings = goToSettings,
        background = R.mipmap.singapore_outside
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(4),
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(space = 12.dp, Alignment.CenterVertically),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(buttonsList.size) { buttonId ->
                Button(
                    buttonsList,
                    buttonId,
                    switchColor
                )
            }
        }
    }
}

@Composable
private fun Button(
    buttonsList: List<Boolean>,
    buttonId: Int,
    switchColor: (Int) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(20.dp))
            .background(
                if (buttonsList[buttonId]) {
                    TrueButton
                } else {
                    FalseButton
                }
            )
            .size(100.dp)
            .clickable { switchColor(buttonId) }
    )
}

@Preview
@Composable
private fun OnOffScreenPreview() {
    ZEscapeThemePreview {
        OnOffScreen(
            goToSettings = {},
            remainingTime = 3600,
            buttonsList = listOf(true, false, true, false, false, false),
            switchColor = {}
        )
    }
}