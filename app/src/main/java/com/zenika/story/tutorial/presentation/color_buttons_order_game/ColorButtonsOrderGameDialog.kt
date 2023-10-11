package com.zenika.story.tutorial.presentation.color_buttons_order_game

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.zenika.R
import com.zenika.story.tutorial.presentation.color_buttons_order_game.component.ColorButton
import com.zenika.story.tutorial.presentation.color_buttons_order_game.component.Stage
import com.zenika.story.tutorial.presentation.component.TutorialDialog
import com.zenika.theme.BlueSymbol
import com.zenika.theme.ComposablePreview
import com.zenika.theme.GreenSymbol
import com.zenika.theme.PurpleSymbol
import com.zenika.theme.RedSymbol
import com.zenika.theme.ZEscapeThemePreview
import com.zenika.theme.itemDialogPadding
import com.zenika.theme.screenPadding

@Composable
fun ColorButtonsOrderGameDialog(
    size: Int,
    onDismissRequest: () -> Unit,
    onColorClick: (String) -> Unit
) {
    TutorialDialog(
        onDismissRequest = onDismissRequest
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Stage(size)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(screenPadding)
                    .wrapContentSize(Alignment.Center)
                    .padding(itemDialogPadding),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                ColorButton(
                    symbol = stringResource(R.string.sharp),
                    color = GreenSymbol,
                    colorName = "green",
                    onColorClick = onColorClick
                )
                ColorButton(
                    symbol = stringResource(R.string.ampersand),
                    color = PurpleSymbol,
                    colorName = "purple",
                    onColorClick = onColorClick
                )
                ColorButton(
                    symbol = stringResource(R.string.percent),
                    color = RedSymbol,
                    colorName = "red",
                    onColorClick = onColorClick
                )
                ColorButton(
                    symbol = stringResource(R.string.at),
                    color = BlueSymbol,
                    colorName = "blue",
                    onColorClick = onColorClick
                )
            }
        }
    }
}

@ComposablePreview
@Composable
private fun ColorButtonsOrderGameDialogPreview() {
    ZEscapeThemePreview {
        ColorButtonsOrderGameDialog(
            size = 2,
            onDismissRequest = {},
            onColorClick = {}
        )
    }
}
