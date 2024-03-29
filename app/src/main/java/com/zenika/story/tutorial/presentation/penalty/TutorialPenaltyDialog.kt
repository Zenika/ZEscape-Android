package com.zenika.story.tutorial.presentation.penalty

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.zenika.R
import com.zenika.story.tutorial.presentation.component.TutorialDialog
import com.zenika.theme.ComposablePreview
import com.zenika.theme.ZEscapeThemePreview
import com.zenika.theme.tutorialBodyMedium

@Composable
fun TutorialPenaltyDialog(
    onDismissRequest: () -> Unit,
    penalty: String
) {
    TutorialDialog(
        onDismissRequest = onDismissRequest,
        backgroundColor = MaterialTheme.colorScheme.errorContainer
    ) {
        val text = if (penalty == "key") {
            stringResource(R.string.penalty_key)
        } else {
            stringResource(R.string.penalty_wrong_code)
        }
        Text(
            text = text,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = tutorialBodyMedium,
            color = MaterialTheme.colorScheme.onErrorContainer
        )
    }
}

@ComposablePreview
@Composable
private fun TutorialPenaltyDialogPreview() {
    ZEscapeThemePreview {
        TutorialPenaltyDialog(
            onDismissRequest = {},
            penalty = "null"
        )
    }
}

