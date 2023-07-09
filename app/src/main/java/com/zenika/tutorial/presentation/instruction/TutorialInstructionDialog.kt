package com.zenika.tutorial.presentation.instruction

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.zenika.R
import com.zenika.tutorial.presentation.component.TutorialDialog
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun TutorialInstructionDialog(
    onDismissRequest: () -> Unit
) {
    TutorialDialog(
        onDismissRequest = onDismissRequest
    ) {
        Text(text = stringResource(R.string.instruction),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@ScreenPreview
@Composable
private fun TutorialInstructionDialogPreview() {
    ZEscapeThemePreview {
        TutorialInstructionDialog(
            onDismissRequest = {}
        )
    }
}
