package com.zenika.adventure.presentation.world_map

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.zenika.ui.theme.ZEscapeTheme

@Composable
fun WorldMapRoute(
    onDismissRequest: () -> Unit,
    openTextRecognition: () -> Unit,
    goBackToPortal: () -> Unit,
    goInsideSingaporeAgency: () -> Unit,
    openOnOffGame: () -> Unit,
    viewModel: WorldMapViewModel = hiltViewModel()
) {
    val agencies by viewModel.agencies.collectAsState()
    val agenciesState by viewModel.agenciesState.collectAsState()

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

@Preview
@Composable
fun WorldMapRoutePreview() {
    ZEscapeTheme {
        WorldMapRoute(
            onDismissRequest = {},
            openTextRecognition = {},
            goBackToPortal = {},
            goInsideSingaporeAgency = {},
            openOnOffGame = {}
        )
    }
}