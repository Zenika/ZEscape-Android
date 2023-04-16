package com.zenika.feature1.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun Feature1Route(
    goToFeature2: () -> Unit
) {
    val viewModel = hiltViewModel<Feature1ViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()

    Feature1Screen(
        Modifier.fillMaxSize(),
        state,
        viewModel::onTouch,
        goToFeature2
    )
}
