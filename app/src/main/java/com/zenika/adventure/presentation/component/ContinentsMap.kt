package com.zenika.adventure.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.zenika.R
import com.zenika.ui.theme.ZEscapeTheme

@Composable
fun ContinentsMap(
    modifier: Modifier
) {
        Image(
            painter = painterResource(id = R.mipmap.continents),
            contentDescription = stringResource(id = R.string.world_map),
            modifier = modifier
        )
}

@Preview
@Composable
fun ContinentsMapPreview() {
    ZEscapeTheme {
        ContinentsMap(
            modifier = Modifier
        )
    }
}