package com.zenika.adventure.presentation.world_map

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun WorldMapRoute(
    onDismissRequest: () -> Unit,
    openTextRecognition: () -> Unit,
    viewModel: WorldMapViewModel = hiltViewModel()
) {
    val agencies by viewModel.agencies.collectAsStateWithLifecycle()

    WorldMapDialog(
        onDismissRequest,
        openTextRecognition,
        agencies
    )
}
