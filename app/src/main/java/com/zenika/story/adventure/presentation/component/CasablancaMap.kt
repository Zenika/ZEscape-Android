package com.zenika.story.adventure.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.zenika.R
import com.zenika.theme.ComposablePreview
import com.zenika.theme.ZEscapeThemePreview

@Composable
fun CasablancaMap(
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = R.mipmap.casablanca_map),
        contentDescription = stringResource(id = R.string.casablanca_map),
        modifier = modifier
    )
}

@ComposablePreview
@Composable
private fun CasablancaMapPreview() {
    ZEscapeThemePreview {
        CasablancaMap(
            modifier = Modifier
        )
    }
}
