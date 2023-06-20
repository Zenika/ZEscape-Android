package com.zenika.adventure.presentation.agency_validation

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.zenika.ui.theme.ZEscapeTheme

@Composable
fun AgencyValidationDialog(
    onDismissRequest: () -> Unit,
    addAgency: () -> Unit,
    agency: String
) {
    AlertDialog(
        onDismissRequest = onDismissRequest,
        confirmButton = {
            ConfirmButton(
                addAgency,
                onDismissRequest
            )
        },
        dismissButton = { DismissButton(onDismissRequest) },
        title = { TitleDialog() },
        text = { TextDialog(agency = agency) }
    )
}

@Composable
fun ConfirmButton(
    addAgency: () -> Unit,
    onDismissRequest: () -> Unit
) {
    Button(onClick = {
        addAgency()
        onDismissRequest()
    }) {
        Text(text = "Confirmer")
    }
}

@Composable
fun DismissButton(onDismissRequest: () -> Unit) {
    Button(onClick = onDismissRequest) {
        Text(text = "Annuler")
    }
}

@Composable
fun TitleDialog() {
    Text(text = "Ajout d'une agence")
}

@Composable
fun TextDialog(agency: String) {
    Text(text = "Voulez-vous ajouter l'agence de $agency à la carte ?")
}

@Preview
@Composable
fun AgencyValidationDialogPreview() {
    ZEscapeTheme {
        AgencyValidationDialog(
            onDismissRequest = {},
            addAgency = {},
            agency = "MONTREAL"
        )
    }
}

