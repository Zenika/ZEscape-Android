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
    viewModel: WorldMapViewModel = hiltViewModel(),
    openOnOffGame: () -> Unit
) {
    val agencies by viewModel.agencies.collectAsState()

    WorldMapDialog(
        onDismissRequest,
        openTextRecognition,
        openOnOffGame,
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
            openOnOffGame = {
            }
        )
    }
}