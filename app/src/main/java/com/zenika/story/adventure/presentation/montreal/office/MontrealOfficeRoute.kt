package com.zenika.story.adventure.presentation.montreal.office

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun MontrealOfficeRoute(
    goBack: () -> Unit,
    goToSettings: () -> Unit,
    openWorldMap: () -> Unit,
    openInventory: () -> Unit,
    viewModel: MontrealOfficeViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(viewModel) {
        viewModel.init()
    }

    MontrealOfficeScreen(
        state,
        goBack,
        goToSettings,
        openWorldMap,
        openInventory,
        viewModel::collectKey
    )
}
