package com.zenika.tutorial.presentation.clue

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.zenika.ui.theme.dialogPadding
import com.zenika.ui.theme.screenPadding
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun ClueDialog(
    clue: Int,
    onDismissRequest: () -> Unit
) {
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = true)
    ) {
        Text(
            text = stringResource(id = clue),
            Modifier
                .fillMaxWidth()
                .padding(screenPadding)
                .background(
                    MaterialTheme.colorScheme.primaryContainer,
                    MaterialTheme.shapes.extraLarge
                )
                .padding(dialogPadding),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@ScreenPreview
@Composable
fun ClueDialogPreview() {
    ZEscapeThemePreview {
        ClueDialog(
            clue = 0
        ) {}
    }
}
