package com.zenika.tutorial.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.zenika.tutorial.presentation.TutorialViewModel
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun GameDialog(
    viewModel: TutorialViewModel,
    onDismissRequest: () -> Unit
) {
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = true)
    ) {
        MiniGameContent(
            viewModel,
            onDismissRequest,
            Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(
                    MaterialTheme.colorScheme.background,
                    MaterialTheme.shapes.extraLarge
                )
        )
    }
}

@Composable
private fun MiniGameContent(
    viewModel: TutorialViewModel,
    onDismissRequest: () -> Unit,
    modifier: Modifier
) {
    val colors by viewModel.colorsSequence.collectAsState()
    val size by viewModel.sequenceSize.collectAsState()
    Column(
        modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Stage(size)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
                .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            ColorButton(
                symbol = "#",
                color = Color.Green,
                colorName = "green",
                colors = colors,
                viewModel = viewModel,
                onDismissRequest = onDismissRequest
            )
            ColorButton(
                symbol = "&",
                color = Color.Yellow,
                colorName = "yellow",
                colors = colors,
                viewModel = viewModel,
                onDismissRequest = onDismissRequest
            )
            ColorButton(
                symbol = "%",
                color = Color.Red,
                colorName = "red",
                colors = colors,
                viewModel = viewModel,
                onDismissRequest = onDismissRequest
            )
            ColorButton(
                symbol = "@",
                color = Color.Blue,
                colorName = "blue",
                colors = colors,
                viewModel = viewModel,
                onDismissRequest = onDismissRequest
            )
        }
    }
}

@Composable
private fun Stage(size: Int) {
    Text(
        text = "$size/4",
        style = MaterialTheme.typography.headlineMedium
    )
}

@Composable
private fun ColorButton(
    symbol: String,
    color: Color,
    colorName: String,
    colors: List<String>,
    viewModel: TutorialViewModel,
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
                    colorName,
                    colors,
                    viewModel,
                    onDismissRequest
                )
            }
    ) {
        Text(text = symbol)
    }
}

fun onColorClick(
    color: String,
    colors: List<String>,
    viewModel: TutorialViewModel,
    onDismissRequest: () -> Unit
) {
    viewModel.addColor(color)
    val isGood = viewModel.checkSequence()
    if (!isGood) {
        onDismissRequest()
        viewModel.initColorsSequence()
    } else if (colors.size >= 4) {
        onDismissRequest()
        viewModel.initColorsSequence()
        viewModel.updateChestState()
    }
}

@ScreenPreview
@Composable
fun GameDialogPreview() {
    ZEscapeThemePreview {
        GameDialog(
            viewModel = TutorialViewModel(),
            onDismissRequest = {}
        )
    }
}
