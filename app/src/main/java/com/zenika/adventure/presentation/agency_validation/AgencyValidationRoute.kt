package com.zenika.adventure.presentation.agency_validation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun AgencyValidationRoute(
    onDismissRequest: () -> Unit,
    goBackToWorldMap: () -> Unit,
    viewModel: AgencyValidationViewModel = hiltViewModel()
) {
    val agency by viewModel.agency.collectAsState()

    AgencyValidationDialog(
        onDismissRequest,
        goBackToWorldMap,
        viewModel::addAgency,
        agency
    )
}