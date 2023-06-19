package com.zenika.tutorial.presentation.penalty

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
fun PenaltyDialog(
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
            stringResource(id = R.string.penalty_game)
        }
        Text(
            text = text,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onErrorContainer
        )
    }
}

@ScreenPreview
@Composable
fun PenaltyDialogPreview() {
    ZEscapeThemePreview {
        PenaltyDialog(
            onDismissRequest = {},
            penalty = "key"
        )
    }
}

