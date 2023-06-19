package com.zenika.tutorial.presentation.hint

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.zenika.data.TutorialHint
import com.zenika.tutorial.presentation.component.TutorialDialog
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun HintDialog(
    hint: TutorialHint,
    onDismissRequest: () -> Unit
) {
    TutorialDialog(
        onDismissRequest = onDismissRequest
    ) {
        Text(
            text = stringResource(id = hint.text),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@ScreenPreview
@Composable
fun HintDialogPreview() {
    ZEscapeThemePreview {
        HintDialog(
            hint = TutorialHint.NO_HINT,
            onDismissRequest = {}
        )
    }
}
