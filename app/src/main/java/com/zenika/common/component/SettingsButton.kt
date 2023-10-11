package com.zenika.common.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.zenika.R
import com.zenika.theme.ComposablePreview
import com.zenika.theme.ZEscapeThemePreview

@Composable
fun SettingsButton(
    goToSettings: () -> Unit
) {
    IconButton(onClick = goToSettings) {
        Icon(Icons.Filled.Settings, stringResource(R.string.settings))
    }
}

@ComposablePreview
@Composable
private fun SettingsButtonPreview() {
    ZEscapeThemePreview {
        SettingsButton {
        }
    }
}
