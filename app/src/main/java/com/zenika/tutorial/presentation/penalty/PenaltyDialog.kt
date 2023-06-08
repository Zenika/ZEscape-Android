package com.zenika.tutorial.presentation.penalty

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.zenika.R
import com.zenika.ui.theme.dialogPadding
import com.zenika.ui.theme.screenPadding
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun PenaltyDialog(
    onDismissRequest: () -> Unit,
    penalty: String
) {
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = true)
    ) {
        val text = if (penalty == "key") {
            stringResource(R.string.penalty_key)
        } else {
            stringResource(id = R.string.penalty_game)
        }
        Text(
            text = text,
            Modifier
                .fillMaxWidth()
                .padding(screenPadding)
                .border(
                    width = 2.dp,
                    color = Color.Black,
                    shape = RoundedCornerShape(18)
                )
                .background(
                    MaterialTheme.colorScheme.errorContainer,
                    MaterialTheme.shapes.extraLarge
                )
                .padding(dialogPadding),
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

