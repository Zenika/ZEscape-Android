package com.zenika.adventure.presentation.world_map

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun WorldMapRoute(
    onDismissRequest: () -> Unit,
    openTextRecognition: () -> Unit,
    goBackToPortal: () -> Unit,
    goInsideSingaporeAgency: () -> Unit,
    openOnOffGame: () -> Unit,
    viewModel: WorldMapViewModel = hiltViewModel()
) {
    val agencies by viewModel.agencies.collectAsStateWithLifecycle()
    val agenciesState by viewModel.agenciesState.collectAsStateWithLifecycle()

    val goToSingaporeAgency = if (agenciesState) {
        goInsideSingaporeAgency
    } else {
        openOnOffGame
    }

    WorldMapDialog(
        onDismissRequest,
        openTextRecognition,
        goBackToPortal,
        goToSingaporeAgency,
        agencies
    )
}
