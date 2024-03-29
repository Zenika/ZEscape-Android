package com.zenika.story.adventure.presentation.agency_validation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun AgencyValidationRoute(
    onDismissRequest: () -> Unit,
    goBackToWorldMap: () -> Unit,
    openPenalty: (String) -> Unit,
    viewModel: AgencyValidationViewModel = hiltViewModel()
) {
    val agency by viewModel.agency.collectAsStateWithLifecycle()
    val event by viewModel.events.collectAsStateWithLifecycle(initialValue = null)
    LaunchedEffect(event) {
        when (event) {
            AgencyValidationEvent.OPEN_MAP -> goBackToWorldMap()
            AgencyValidationEvent.PENALTY -> openPenalty("agency")
            null -> Unit
        }
    }

    AgencyValidationDialog(
        onDismissRequest,
        viewModel::dismissAgency,
        viewModel::confirmAgency,
        agency
    )
}
