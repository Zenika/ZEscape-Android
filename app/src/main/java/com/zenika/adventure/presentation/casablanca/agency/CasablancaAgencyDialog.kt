package com.zenika.adventure.presentation.casablanca.agency

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.zenika.R
import com.zenika.adventure.presentation.component.AdventureDialog
import com.zenika.ui.theme.adventureBodyMedium
import com.zenika.ui.theme.screenPadding
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun CasablancaAgencyDialog(onDismissRequest: () -> Unit) {
    AdventureDialog(
        onDismissRequest = onDismissRequest
    ) {
        Text(
            text = stringResource(R.string.instruction_casablanca_agency),
            modifier = Modifier
                .fillMaxWidth()
                .padding(screenPadding)
                .background(
                    MaterialTheme.colorScheme.primaryContainer,
                    MaterialTheme.shapes.extraLarge
                ),
            textAlign = TextAlign.Center,
            style = adventureBodyMedium
        )
    }
}

@Preview
@Composable
private fun CasablancaAgencyDialogPreview() {
    ZEscapeThemePreview {
        CasablancaAgencyDialog(
            onDismissRequest = {}
        )
    }
}