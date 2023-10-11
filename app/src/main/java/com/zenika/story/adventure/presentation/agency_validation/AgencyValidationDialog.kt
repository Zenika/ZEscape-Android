package com.zenika.story.adventure.presentation.agency_validation

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.zenika.R
import com.zenika.theme.ComposablePreview
import com.zenika.theme.ZEscapeThemePreview
import com.zenika.theme.adventureBodyMedium

@Composable
fun AgencyValidationDialog(
    onDismissRequest: () -> Unit,
    dismissAgency: () -> Unit,
    confirmAgency: () -> Unit,
    agency: String
) {
    AlertDialog(
        onDismissRequest = onDismissRequest,
        confirmButton = {
            ConfirmButton(
                confirmAgency
            )
        },
        dismissButton = {
            DismissButton(
                dismissAgency
            )
        },
        title = { TitleDialog() },
        text = { TextDialog(agency = agency) }
    )
}

@Composable
private fun ConfirmButton(
    confirmAgency: () -> Unit
) {
    Button(onClick = confirmAgency) {
        Text(text = stringResource(R.string.confirm))
    }
}

@Composable
private fun DismissButton(
    dismissAgency: () -> Unit
) {
    Button(onClick = dismissAgency) {
        Text(text = stringResource(R.string.cancel))
    }
}

@Composable
private fun TitleDialog() {
    Text(
        text = stringResource(R.string.agency_add),
        style = adventureBodyMedium
    )
}

@Composable
private fun TextDialog(agency: String) {
    Text(
        text = stringResource(R.string.agency_validation,
            agency.lowercase().replaceFirstChar { it.uppercase() }),
        style = adventureBodyMedium
    )
}

@ComposablePreview
@Composable
private fun AgencyValidationDialogPreview() {
    ZEscapeThemePreview {
        AgencyValidationDialog(
            onDismissRequest = {},
            dismissAgency = {},
            confirmAgency = {},
            agency = "MONTREAL"
        )
    }
}

