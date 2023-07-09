package com.zenika.presentation.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.zenika.R
import com.zenika.utils.ComposablePreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun ReturnButton(
    goBack: () -> Unit
) {
    IconButton(onClick = goBack) {
        Icon(Icons.Filled.ArrowBack, stringResource(R.string.retour))
    }
}

@ComposablePreview
@Composable
private fun ReturnButtonPreview() {
    ZEscapeThemePreview {
        ReturnButton(
            goBack = {}
        )
    }
}
