package com.zenika.adventure.presentation.singapore.on_off_game

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.EaseOutCubic
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.unit.dp
import com.zenika.R
import com.zenika.adventure.presentation.component.ScaffoldScreen
import com.zenika.data.AdventureHint
import com.zenika.ui.theme.FalseButton
import com.zenika.ui.theme.TrueButton
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun OnOffScreen(
    goToSettings: () -> Unit,
    openHintValidation: (AdventureHint) -> Unit,
    remainingTime: Int,
    buttonsList: List<Boolean>,
    switchColor: (Int) -> Unit
) {
    ScaffoldScreen(
        remainingTime = remainingTime,
        goToSettings = goToSettings,
        openHintValidation = { openHintValidation(AdventureHint.ON_OFF_HINT) },
        background = R.mipmap.singapore_outside
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(4),
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(space = 12.dp, Alignment.CenterVertically),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(buttonsList.size) { buttonId ->
                ColorButton(
                    buttonsList[buttonId],
                    onClick = { switchColor(buttonId) }
                )
            }
        }
    }
}

@Composable
private fun ColorButton(
    isButtonGreen: Boolean,
    onClick: () -> Unit
) {
    val color by animateColorAsState(
        targetValue = if (isButtonGreen) TrueButton else FalseButton,
        animationSpec = tween(300, easing = EaseOutCubic),
        label = "ColorButton's color"
    )

    val interactionSource = remember { MutableInteractionSource() }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(20.dp))
            .drawBehind { drawRect(color) }
            .size(100.dp)
            .clickable(interactionSource, null, onClick = onClick)
    ) {
        Text(
            text = if (isButtonGreen) "ON" else "OFF",
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@ScreenPreview
@Composable
private fun OnOffScreenPreview() {
    ZEscapeThemePreview {
        var isGreen by remember { mutableStateOf(true) }
        OnOffScreen(
            goToSettings = {},
            openHintValidation = {},
            remainingTime = 3600,
            buttonsList = listOf(isGreen, false, true, false, false, false),
            switchColor = { isGreen = !isGreen }
        )
    }
}
