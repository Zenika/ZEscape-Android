package com.zenika.tutorial.presentation.mini_game.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun ColorButton(
    symbol: String,
    color: Color,
    colorName: String,
    colors: List<String>,
    addColor: (String) -> Unit,
    checkSequence: () -> Boolean,
    initColorsSequence: () -> Unit,
    updateChestState: () -> Unit,
    onDismissRequest: () -> Unit
) {
    Box(
        modifier = Modifier
            .size(40.dp)
            .clip(CircleShape)
            .background(color)
            .wrapContentSize(Alignment.Center)
            .clickable {
                onColorClick(
                    color = colorName,
                    colors = colors,
                    addColor = addColor,
                    checkSequence = checkSequence,
                    initColorsSequence = initColorsSequence,
                    updateChestState = updateChestState,
                    onDismissRequest = onDismissRequest
                )
            }
    ) {
        Text(text = symbol)
    }
}

fun onColorClick(
    color: String,
    colors: List<String>,
    addColor: (String) -> Unit,
    checkSequence: () -> Boolean,
    initColorsSequence: () -> Unit,
    updateChestState: () -> Unit,
    onDismissRequest: () -> Unit
) {
    addColor(color)
    if (!checkSequence()) {
        onDismissRequest()
        initColorsSequence()
    } else if (colors.size >= 4) {
        onDismissRequest()
        initColorsSequence()
        updateChestState()
    }
}

@ScreenPreview
@Composable
fun ColorButtonPreview() {
    ZEscapeThemePreview {
        ColorButton(
            symbol = "@",
            color = Color.Blue,
            colorName = "blue",
            colors = listOf("blue"),
            addColor = {},
            checkSequence = { false },
            initColorsSequence = {},
            updateChestState = {},
            onDismissRequest = {}
        )
    }
}
