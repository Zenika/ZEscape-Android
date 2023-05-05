package com.zenika.tutorial.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
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
import com.zenika.R
import com.zenika.ui.theme.dialogPadding
import com.zenika.ui.theme.screenPadding
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun InstructionDialog(
    onDismissRequest: () -> Unit
) {
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = true)
    ) {
        InstructionContent(
            Modifier
                .fillMaxWidth()
                .padding(screenPadding)
                .background(
                    MaterialTheme.colorScheme.background.copy(alpha = 0.7F),
                    MaterialTheme.shapes.extraLarge
                )
        )
    }
}

@Composable
private fun InstructionContent(
    modifier: Modifier
) {
    Column(
        modifier
            .padding(dialogPadding)
    ) {
        Text(
            text = stringResource(id = R.string.instruction),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@ScreenPreview
@Composable
fun InstructionDialogPreview() {
    ZEscapeThemePreview {
        InstructionDialog(
            onDismissRequest = {}
        )
    }
}
