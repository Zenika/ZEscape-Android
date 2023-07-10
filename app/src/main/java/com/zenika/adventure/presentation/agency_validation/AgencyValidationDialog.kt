package com.zenika.adventure.presentation.agency_validation

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.zenika.R
import com.zenika.ui.theme.adventureBodyMedium
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

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
fun ConfirmButton(
    confirmAgency: () -> Unit
) {
    Button(onClick = confirmAgency) {
        Text(text = stringResource(R.string.confirm))
    }
}

@Composable
fun DismissButton(
    dismissAgency: () -> Unit
) {
    Button(onClick = dismissAgency) {
        Text(text = stringResource(R.string.cancel))
    }
}

@Composable
fun TitleDialog() {
    Text(text = stringResource(R.string.agency_add),
        style = adventureBodyMedium)
}

@Composable
fun TextDialog(agency: String) {
    Text(text = stringResource(R.string.agency_validation,
        agency.lowercase().replaceFirstChar { it.uppercase() }),
        style = adventureBodyMedium)
}

@ScreenPreview
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

