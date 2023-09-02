package com.zenika.adventure.presentation.montreal.agency

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.zenika.R
import com.zenika.adventure.presentation.component.AdventureDialog
import com.zenika.ui.theme.adventureBodyMedium
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun MontrealAgencyDialog(
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier
) {
    AdventureDialog(onDismissRequest = onDismissRequest) {
        Text(
            text = stringResource(R.string.instruction_montreal_agency),
            modifier = modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = adventureBodyMedium
        )
    }
}

@Preview
@Composable
private fun MontrealAgencyDialogPreview() {
    ZEscapeThemePreview {
        MontrealAgencyDialog(onDismissRequest = {})
    }
}
