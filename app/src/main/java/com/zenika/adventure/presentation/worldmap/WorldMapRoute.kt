package com.zenika.adventure.presentation.worldmap

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
    goOutsideSingaporeAgency: () -> Unit,
    goInsideCasablancaAgency: () -> Unit,
    goOutsideCasablancaAgency: () -> Unit,
    goInsideMontrealAgency: () -> Unit,
    goOutsideMontrealAgency: () -> Unit,
    openAgencyTeaser: () -> Unit,
    viewModel: WorldMapViewModel = hiltViewModel()
) {
    val agencies by viewModel.agencies.collectAsStateWithLifecycle()
    val state by viewModel.state.collectAsStateWithLifecycle()

    val goToSingaporeAgency = if (state.isSingaporeAgencyOpen) {
        goInsideSingaporeAgency
    } else {
        goOutsideSingaporeAgency
    }

    val goToCasablancaAgency = if (state.isCasablancaAgencyOpen) {
        goInsideCasablancaAgency
    } else {
        goOutsideCasablancaAgency
    }

    val goToMontrealAgency = if (state.isMontrealAgencyOpen) {
        goInsideMontrealAgency
    } else {
        goOutsideMontrealAgency
    }

    WorldMapDialog(
        onDismissRequest,
        openTextRecognition,
        goBackToPortal,
        goToSingaporeAgency,
        goToCasablancaAgency,
        goToMontrealAgency,
        openAgencyTeaser,
        agencies
    )
}
