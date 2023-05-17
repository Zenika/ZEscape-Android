package com.zenika.tutorial.presentation.mini_game

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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.zenika.R
import com.zenika.tutorial.presentation.mini_game.component.ColorButton
import com.zenika.tutorial.presentation.mini_game.component.Stage
import com.zenika.ui.theme.BlueSymbol
import com.zenika.ui.theme.GreenSymbol
import com.zenika.ui.theme.PurpleSymbol
import com.zenika.ui.theme.RedSymbol
import com.zenika.ui.theme.dialogPadding
import com.zenika.ui.theme.itemDialogPadding
import com.zenika.ui.theme.screenPadding
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun MiniGameDialog(
    modifier: Modifier,
    size: Int,
    addColor: (String) -> Unit

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
            ColorButton(
                symbol = stringResource(id = R.string.sharp),
                color = GreenSymbol,
                colorName = "green",
                addColor = addColor
            )
            ColorButton(
                symbol = stringResource(id = R.string.ampersand),
                color = PurpleSymbol,
                colorName = "purple",
                addColor = addColor
            )
            ColorButton(
                symbol = stringResource(id = R.string.percent),
                color = RedSymbol,
                colorName = "red",
                addColor = addColor
            )
            ColorButton(
                symbol = stringResource(id = R.string.at),
                color = BlueSymbol,
                colorName = "blue",
                addColor = addColor
            )
        }
    }
}

@ScreenPreview
@Composable
fun MiniGameDialogPreview() {
    ZEscapeThemePreview {
        MiniGameDialog(
            Modifier
                .fillMaxWidth()
                .padding(screenPadding)
                .background(
                    MaterialTheme.colorScheme.primaryContainer,
                    MaterialTheme.shapes.extraLarge
                ),
            size = 2,
            addColor = {}
        )
    }
}
