package com.zenika.adventure.presentation.singapore.instruction

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.zenika.R
import com.zenika.adventure.presentation.component.AdventureDialog
import com.zenika.ui.theme.adventureBodyMedium
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun InstructionSingaporeDialog(
    onDismissRequest: () -> Unit
) {
    AdventureDialog(
        onDismissRequest = onDismissRequest
    ) {
        Text(
            text = stringResource(R.string.instruction_singapore),
            textAlign = TextAlign.Center,
            style = adventureBodyMedium
        )
    }
}

@ScreenPreview
@Composable
fun InstructionSingaporeDialogPreview() {
    ZEscapeThemePreview {
        InstructionSingaporeDialog(
            onDismissRequest = {}
        )
    }
}
