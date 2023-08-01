package com.zenika.tutorial.presentation.instruction

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.zenika.R
import com.zenika.tutorial.presentation.component.TutorialDialog
import com.zenika.ui.theme.tutorialBodyMedium
import com.zenika.utils.ComposablePreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun TutorialInstructionDialog(
    onDismissRequest: () -> Unit
) {
    TutorialDialog(
        onDismissRequest = onDismissRequest
    ) {
        Text(
            text = stringResource(R.string.instruction),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = tutorialBodyMedium
        )
    }
}

@ComposablePreview
@Composable
private fun TutorialInstructionDialogPreview() {
    ZEscapeThemePreview {
        TutorialInstructionDialog(
            onDismissRequest = {}
        )
    }
}
