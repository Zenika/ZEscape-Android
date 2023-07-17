package com.zenika.tutorial.presentation.hint

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.zenika.data.TutorialHint
import com.zenika.tutorial.presentation.component.TutorialDialog
import com.zenika.ui.theme.tutorialBodyMedium
import com.zenika.utils.ComposablePreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun TutorialHintDialog(
    hint: TutorialHint,
    onDismissRequest: () -> Unit
) {
    TutorialDialog(
        onDismissRequest = onDismissRequest
    ) {
        Text(
            text = stringResource(hint.text),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = tutorialBodyMedium
        )
    }
}

@ComposablePreview
@Composable
private fun TutorialHintDialogPreview() {
    ZEscapeThemePreview {
        TutorialHintDialog(
            hint = TutorialHint.NO_HINT,
            onDismissRequest = {}
        )
    }
}
