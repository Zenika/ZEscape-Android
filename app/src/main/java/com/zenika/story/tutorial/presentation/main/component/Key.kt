package com.zenika.story.tutorial.presentation.main.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.zenika.R
import com.zenika.theme.ComposablePreview
import com.zenika.theme.ZEscapeThemePreview
import com.zenika.theme.screenPadding

@Composable
fun Key(
    collectKey: () -> Unit,
    modifier: Modifier
) {
    Image(
        painter = painterResource(R.mipmap.key),
        contentDescription = stringResource(R.string.key_image),
        contentScale = ContentScale.Fit,
        modifier = modifier
            .clickable(onClick = collectKey)
    )
}

@ComposablePreview
@Composable
private fun KeyPreview() {
    ZEscapeThemePreview {
        Key(
            collectKey = {},
            modifier = Modifier
                .padding(screenPadding)
        )
    }
}
