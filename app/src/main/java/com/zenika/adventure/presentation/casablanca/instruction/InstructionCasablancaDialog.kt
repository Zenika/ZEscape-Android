package com.zenika.adventure.presentation.casablanca.instruction

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
fun InstructionCasablancaDialog(
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier
) {
    AdventureDialog(onDismissRequest = onDismissRequest) {
        Text(
            text = stringResource(R.string.instruction_casablanca),
            modifier = modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = adventureBodyMedium
        )
    }
}

@ScreenPreview
@Composable
private fun InstructionCasablancaDialogPreview() {
    ZEscapeThemePreview {
        InstructionCasablancaDialog(
            onDismissRequest = {}
        )
    }
}
