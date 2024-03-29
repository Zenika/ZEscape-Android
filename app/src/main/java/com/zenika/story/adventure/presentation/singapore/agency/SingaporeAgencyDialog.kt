package com.zenika.story.adventure.presentation.singapore.agency

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.zenika.R
import com.zenika.story.adventure.presentation.component.AdventureDialog
import com.zenika.theme.ZEscapeThemePreview
import com.zenika.theme.adventureBodyMedium

@Composable
fun SingaporeAgencyDialog(onDismissRequest: () -> Unit) {
    AdventureDialog(onDismissRequest = onDismissRequest) {
        Text(
            text = stringResource(R.string.instruction_singapore_agency),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = adventureBodyMedium
        )
    }
}

@Preview
@Composable
private fun SingaporeAgencyDialogPreview() {
    ZEscapeThemePreview {
        SingaporeAgencyDialog(onDismissRequest = {})
    }
}
