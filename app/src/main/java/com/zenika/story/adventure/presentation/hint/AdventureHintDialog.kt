package com.zenika.story.adventure.presentation.hint

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.zenika.story.adventure.domain.model.AdventureHint
import com.zenika.story.adventure.presentation.component.AdventureDialog
import com.zenika.theme.ComposablePreview
import com.zenika.theme.ZEscapeThemePreview
import com.zenika.theme.adventureBodyMedium

@Composable
fun AdventureHintDialog(
    hint: String,
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier
) {
    AdventureDialog(
        onDismissRequest = onDismissRequest
    ) {
        Text(
            text = stringResource(AdventureHint.valueOf(hint).text),
            modifier = modifier.fillMaxWidth(),
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
