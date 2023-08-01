package com.zenika.adventure.presentation.hintvalidation

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.zenika.R
import com.zenika.ui.theme.adventureBodyMedium
import com.zenika.utils.ComposablePreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun AdventureHintValidationDialog(
    onDismissRequest: () -> Unit,
    dismissHint: () -> Unit,
    showHint: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismissRequest,
        confirmButton = { ConfirmButton(showHint) },
        dismissButton = { DismissButton(dismissHint) },
        title = {
            Text(
                text = stringResource(R.string.hint),
                style = adventureBodyMedium
            )
        },
        text = {
            Text(
                text = stringResource(R.string.hint_validation),
                style = adventureBodyMedium
            )
        }
    )
}

@Composable
private fun ConfirmButton(
    showHint: () -> Unit
) {
    Button(onClick = showHint) {
        Text(text = stringResource(R.string.confirm))
    }
}

@Composable
private fun DismissButton(
    dismissHint: () -> Unit
) {
    Button(onClick = dismissHint) {
        Text(text = stringResource(R.string.cancel))
    }
}

@ComposablePreview
@Composable
private fun AdventureHintValidationDialogPreview() {
    ZEscapeThemePreview {
        AdventureHintValidationDialog(
            onDismissRequest = {},
            dismissHint = {},
            showHint = {}
        )
    }
}
