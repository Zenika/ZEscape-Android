package com.zenika.adventure.presentation.score

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.zenika.R
import com.zenika.adventure.presentation.component.AdventureDialog
import com.zenika.ui.theme.adventureBodyMedium
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun AdventureScoreDialog(
    onDismissRequest: () -> Unit
) {
    AdventureDialog(
        onDismissRequest = onDismissRequest
    ) {
        Text(
            text = stringResource(R.string.final_text),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = adventureBodyMedium
        )
    }
}

@ScreenPreview
@Composable
private fun AdventureScoreDialogPreview() {
    ZEscapeThemePreview {
        AdventureScoreDialog(
            onDismissRequest = {}
        )
    }
}
