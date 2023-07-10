package com.zenika.adventure.presentation.agency_validation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun AgencyValidationRoute(
    onDismissRequest: () -> Unit,
    goBackToWorldMap: () -> Unit,
    viewModel: AgencyValidationViewModel = hiltViewModel()
) {
    val agency by viewModel.agency.collectAsStateWithLifecycle()

    LaunchedEffect(viewModel) {
        viewModel.events.collect { event ->
            when (event) {
                AgencyValidationEvent.DISMISS -> onDismissRequest()
                AgencyValidationEvent.MAP -> goBackToWorldMap()
            }
        }
    }

    AgencyValidationDialog(
        onDismissRequest,
        viewModel::dismissAgency,
        viewModel::confirmAgency,
        agency
    )
}