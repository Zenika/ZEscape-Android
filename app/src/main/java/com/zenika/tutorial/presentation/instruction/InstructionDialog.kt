package com.zenika.tutorial.presentation.instruction

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
import com.zenika.R
import com.zenika.ui.theme.dialogPadding
import com.zenika.ui.theme.screenPadding
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun InstructionDialog(
    modifier: Modifier
) {
    Column(
        modifier
            .padding(dialogPadding)
    ) {
        Text(
            text = stringResource(id = R.string.instruction),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@ScreenPreview
@Composable
fun InstructionDialogPreview() {
    ZEscapeThemePreview {
        InstructionDialog(
            modifier = Modifier
                .fillMaxWidth()
                .padding(screenPadding)
                .background(
                    MaterialTheme.colorScheme.primaryContainer,
                    MaterialTheme.shapes.extraLarge
                )
        )
    }
}
