package com.zenika.adventure.presentation.hint

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.zenika.adventure.presentation.component.AdventureDialog
import com.zenika.data.AdventureHint
import com.zenika.ui.theme.adventureBodyMedium
import com.zenika.utils.ComposablePreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun AdventureHintDialog(
    hint: String,
    onDismissRequest: () -> Unit
) {
    AdventureDialog(
        onDismissRequest = onDismissRequest
    ) {
        Text(
            text = stringResource(AdventureHint.valueOf(hint).text),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = adventureBodyMedium
        )
    }
}

@ComposablePreview
@Composable
private fun AdventureHintDialogPreview() {
    ZEscapeThemePreview {
        AdventureHintDialog(
            hint = AdventureHint.NO_HINT.name,
            onDismissRequest = {}
        )
    }
}
