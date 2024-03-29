package com.zenika.story.adventure.presentation.singapore.instruction

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.zenika.R
import com.zenika.story.adventure.presentation.component.AdventureDialog
import com.zenika.theme.ScreenPreview
import com.zenika.theme.ZEscapeThemePreview
import com.zenika.theme.adventureBodyMedium

@Composable
fun InstructionSingaporeDialog(onDismissRequest: () -> Unit) {
    AdventureDialog(onDismissRequest = onDismissRequest) {
        Text(
            text = stringResource(R.string.instruction_singapore),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = adventureBodyMedium
        )
    }
}

@ScreenPreview
@Composable
private fun InstructionSingaporeDialogPreview() {
    ZEscapeThemePreview {
        InstructionSingaporeDialog(onDismissRequest = {})
    }
}
