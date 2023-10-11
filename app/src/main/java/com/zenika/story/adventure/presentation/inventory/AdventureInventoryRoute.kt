package com.zenika.story.adventure.presentation.inventory

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun AdventureInventoryRoute(
    onDismissRequest: () -> Unit,
    showItem: (Int) -> Unit,
    openPenalty: (String) -> Unit,
    viewModel: AdventureInventoryViewModel = hiltViewModel()
) {
    val items by viewModel.inventoryItems.collectAsStateWithLifecycle()

    LaunchedEffect(viewModel) {
        viewModel.init()
        viewModel.events.collect { event ->
            when (event) {
                is ItemEvent.OpenPenalty -> openPenalty(event.penalty)
                is ItemEvent.ShowItem -> showItem(event.item)
            }
        }
    }

    AdventureInventoryDialog(
        items,
        viewModel::onItemClick,
        onDismissRequest
    )
}
