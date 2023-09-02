package com.zenika.adventure.presentation.montreal.agency_map

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun MontrealAgencyMapRoute(
    goToScan: (String) -> Unit,
    viewModel: MontrealAgencyMapViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    MontrealAgencyMap(state, goToScan)
}
