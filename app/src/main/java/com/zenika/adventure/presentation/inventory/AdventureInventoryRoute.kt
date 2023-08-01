package com.zenika.adventure.presentation.inventory

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun AdventureInventoryRoute(
    onDismissRequest: () -> Unit,
    showItem: (Int) -> Unit,
    viewModel: AdventureInventoryViewModel = hiltViewModel()
) {
    val items by viewModel.inventoryItems.collectAsStateWithLifecycle()

    AdventureInventoryDialog(
        items,
        showItem,
        onDismissRequest
    )
}
