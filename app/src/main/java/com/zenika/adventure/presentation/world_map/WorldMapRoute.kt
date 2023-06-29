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
    goToCasablanca: () -> Unit,
    viewModel: WorldMapViewModel = hiltViewModel()
) {
    val agencies by viewModel.agencies.collectAsStateWithLifecycle()
    val isSingaporeAgencyOpen by viewModel.isSingaporeAgencyOpen.collectAsStateWithLifecycle()

    val goToSingaporeAgency = if (isSingaporeAgencyOpen) {
        goInsideSingaporeAgency
    } else {
        openOnOffGame
    }

    WorldMapDialog(
        onDismissRequest,
        openTextRecognition,
        goBackToPortal,
        goToSingaporeAgency,
        goToCasablanca,
        agencies
    )
}
