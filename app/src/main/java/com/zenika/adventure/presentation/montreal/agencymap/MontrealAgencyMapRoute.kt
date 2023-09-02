package com.zenika.adventure.presentation.montreal.agencymap

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun MontrealAgencyMapRoute(
    goToScan: (String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: MontrealAgencyMapViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    MontrealAgencyMap(state, goToScan, modifier)
}
