package com.zenika.tutorial.presentation.component.welcome_map

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.zenika.R
import com.zenika.tutorial.presentation.map.MapViewModel

@Composable
fun EndMapRoute(
    finishGame: () -> Unit,
    mapViewModel: MapViewModel = hiltViewModel()
) {
    val mapVisible by mapViewModel.endMapVisible.collectAsState()

    if (mapVisible) {
        EndMap(R.string.end_map, mapViewModel::hideEndMap)
    } else {
        EndMap(R.string.end_map2) { finishGame() }
    }
}