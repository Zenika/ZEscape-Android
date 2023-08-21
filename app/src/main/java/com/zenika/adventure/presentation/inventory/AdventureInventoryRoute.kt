package com.zenika.adventure.presentation.inventory

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
    val event by viewModel.event.collectAsStateWithLifecycle(initialValue = ItemEvent.None)

    LaunchedEffect(event) {
        when (val theEvent = event) {
            ItemEvent.None -> Unit
            is ItemEvent.OpenPenalty -> openPenalty(theEvent.penalty)
            is ItemEvent.ShowItem -> showItem(theEvent.item)
        }
    }

    AdventureInventoryDialog(
        items,
        viewModel::onItemClick,
        onDismissRequest
    )
}
