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
fun ContinentsMap(
    modifier: Modifier
) {
    Image(
        painter = painterResource(R.mipmap.continents),
        contentDescription = stringResource(R.string.world_map),
        modifier = modifier
    )
}

@ComposablePreview
@Composable
private fun ContinentsMapPreview() {
    ZEscapeThemePreview {
        ContinentsMap(
            modifier = Modifier
        )
    }
}
