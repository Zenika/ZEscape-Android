package com.zenika.tutorial.presentation.map.welcome_map

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.zenika.R
import com.zenika.tutorial.presentation.map.MapViewModel

@Composable
fun WelcomeMapRoute(
    openInstruction: () -> Unit,
    viewModel: MapViewModel = hiltViewModel()
) {
    val firstMapVisible by viewModel.welcomeMap1Visible.collectAsState()
    val secondMapVisible by viewModel.welcomeMap2Visible.collectAsState()

    if (firstMapVisible) {
        WelcomeMap(R.string.welcome_map, viewModel::hideWelcomeFirstMap)
    } else if (secondMapVisible) {
        WelcomeMap(R.string.welcome_map2, viewModel::hideWelcomeSecondMap)
    } else {
        WelcomeMap(R.string.welcome_map3) { openInstruction() }
    }
}