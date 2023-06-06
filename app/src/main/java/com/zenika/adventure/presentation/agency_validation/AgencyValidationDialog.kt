package com.zenika.adventure.presentation.agency_validation

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.zenika.R
import com.zenika.ui.theme.ZEscapeTheme
import com.zenika.ui.theme.adventureBodyMedium

@Composable
fun AgencyValidationDialog(
    onDismissRequest: () -> Unit,
    goBackToWorldMap: () -> Unit,
    addAgency: () -> Unit,
    agency: String
) {
    AlertDialog(
        onDismissRequest = onDismissRequest,
        confirmButton = {
            ConfirmButton(
                addAgency,
                onDismissRequest,
                goBackToWorldMap
            )
        },
        dismissButton = {
            DismissButton(
                onDismissRequest,
                goBackToWorldMap
            )
        },
        title = { TitleDialog() },
        text = { TextDialog(agency = agency) }
    )
}

@Composable
fun ConfirmButton(
    addAgency: () -> Unit,
    onDismissRequest: () -> Unit,
    goBackToWorldMap: () -> Unit
) {
    Button(onClick = {
        addAgency()
        onDismissRequest()
        goBackToWorldMap()
    }) {
        Text(text = stringResource(R.string.confirm))
    }
}

@Composable
fun DismissButton(
    onDismissRequest: () -> Unit,
    goBackToWorldMap: () -> Unit
) {
    Button(onClick = {
        onDismissRequest()
        goBackToWorldMap()
    }) {
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

@Preview
@Composable
fun AgencyValidationDialogPreview() {
    ZEscapeTheme {
        AgencyValidationDialog(
            onDismissRequest = {},
            goBackToWorldMap = {},
            addAgency = {},
            agency = "MONTREAL"
        )
    }
}

