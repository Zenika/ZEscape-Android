package com.zenika.common.component

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.zenika.R
import com.zenika.theme.ComposablePreview
import com.zenika.theme.ZEscapeThemePreview

@Composable
fun HintButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(painterResource(R.mipmap.hint_icon), stringResource(R.string.hint))
    }
}

@ComposablePreview
@Composable
private fun ReturnButtonPreview() {
    ZEscapeThemePreview {
        HintButton(
            onClick = {}
        )
    }
}
