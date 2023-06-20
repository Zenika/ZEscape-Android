package com.zenika.adventure.presentation.agency_validation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun AgencyValidationRoute(
    onDismissRequest: () -> Unit,
    viewModel: AgencyValidationViewModel = hiltViewModel()
) {
    val agency by viewModel.agency.collectAsState()

    AgencyValidationDialog(
        onDismissRequest,
        viewModel::addAgency,
        agency
    )
}