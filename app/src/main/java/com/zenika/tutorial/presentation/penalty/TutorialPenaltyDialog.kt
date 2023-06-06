package com.zenika.tutorial.presentation.penalty

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.zenika.R
import com.zenika.tutorial.presentation.component.TutorialDialog
import com.zenika.ui.theme.tutorialBodyMedium
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

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
            stringResource(R.string.penalty_game)
        }
        Text(
            text = text,
            textAlign = TextAlign.Center,
            style = tutorialBodyMedium,
            color = MaterialTheme.colorScheme.onErrorContainer
        )
    }
}

@ScreenPreview
@Composable
private fun TutorialPenaltyDialogPreview() {
    ZEscapeThemePreview {
        TutorialPenaltyDialog(
            onDismissRequest = {},
            penalty = "key"
        )
    }
}

