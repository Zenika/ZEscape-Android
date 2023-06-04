package com.zenika.game.colorbuttons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zenika.game.colorbuttons.component.ColorButton
import com.zenika.game.colorbuttons.component.Stage

val dialogPadding = 16.dp
val itemDialogPadding = 8.dp

@Composable
fun ColorButtonsOrderGameDialog(
    modifier: Modifier,
    size: Int,
    addColor: (String) -> Unit,
    colors: List<CharAndColor>
) {
    Column(
        modifier
            .padding(dialogPadding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Stage(size)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
                .padding(itemDialogPadding),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            colors.forEach {
                ColorButton(
                    symbol = it.char.toString(),
                    color = it.color,
                    colorName = "green",
                    addColor = addColor
                )
            }
        }
    }
}

@Preview
@Composable
fun ColorButtonsOrderGameDialogPreview() {
        ColorButtonsOrderGameDialog(
            Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(
                    MaterialTheme.colorScheme.primaryContainer,
                    MaterialTheme.shapes.extraLarge
                ),
            size = 2,
            addColor = {},
            colors = listOf(
                CharAndColor('#', Color(0xFF4CAF50)),
                CharAndColor('&', Color(0xFF9727B0)),
                CharAndColor('%', Color(0xFFF44336)),
                CharAndColor('@', Color(0xFF2196F3)),
            )
        )
}
