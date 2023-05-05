package com.zenika.tutorial.presentation.component

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.zenika.R
import com.zenika.ui.theme.BlueSymbol
import com.zenika.ui.theme.GreenSymbol
import com.zenika.ui.theme.RedSymbol
import com.zenika.ui.theme.YellowSymbol
import com.zenika.utils.ComposablePreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun Code() {
    Row {
        Text(
            text = stringResource(id = R.string.at),
            color = BlueSymbol
        )
        Text(
            text = stringResource(id = R.string.sharp),
            color = GreenSymbol
        )
        Text(
            text = stringResource(id = R.string.percent),
            color = RedSymbol
        )
        Text(
            text = stringResource(id = R.string.ampersand),
            color = YellowSymbol
        )
    }
}

@ComposablePreview
@Composable
fun CodePreview() {
    ZEscapeThemePreview {
        Code()
    }
}