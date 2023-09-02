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
    goToCasablancaAgency: () -> Unit,
    goToMontrealAgency: () -> Unit,
    openAgencyTeaser: () -> Unit,
    viewModel: WorldMapViewModel = hiltViewModel()
) {
    val agencies by viewModel.agencies.collectAsStateWithLifecycle()
    val isSingaporeAgencyOpen by viewModel.isSingaporeAgencyOpen.collectAsStateWithLifecycle()

    val goToSingaporeAgency = if (isSingaporeAgencyOpen) {
        goInsideSingaporeAgency
    } else {
        goOutsideSingaporeAgency
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
