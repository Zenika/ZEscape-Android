package com.zenika.adventure.presentation.penalty

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.zenika.R
import com.zenika.adventure.presentation.component.AdventureDialog
import com.zenika.ui.theme.adventureBodyMedium
import com.zenika.utils.ComposablePreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun AdventurePenaltyDialog(
    onDismissRequest: () -> Unit,
    penalty: String,
    modifier: Modifier = Modifier
) {
    val penaltyRes = when (penalty) {
        "hook" -> R.string.penalty_hook
        "sword" -> R.string.penalty_sword
        "door" -> R.string.penalty_force_door
        "hotel" -> R.string.penalty_sleep_hotel
        "intercom" -> R.string.penalty_ring_intercom
        "agency" -> R.string.penalty_wrong_agency
        else -> R.string.penalty
    }

    AdventureDialog(
        onDismissRequest = onDismissRequest,
        backgroundColor = MaterialTheme.colorScheme.errorContainer
    ) {
        Text(
            text = stringResource(penaltyRes),
            modifier = modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = adventureBodyMedium,
            color = MaterialTheme.colorScheme.onErrorContainer
        )
    }
}

@ComposablePreview
@Composable
private fun AdventurePenaltyDialogPreview() {
    ZEscapeThemePreview {
        AdventurePenaltyDialog(
            onDismissRequest = {},
            penalty = "null"
        )
    }
}
