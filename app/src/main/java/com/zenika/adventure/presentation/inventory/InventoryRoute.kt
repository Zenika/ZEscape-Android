package com.zenika.adventure.presentation.inventory

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun InventoryRoute(
    onDismissRequest: () -> Unit,
    showItem: (Int) -> Unit,
    viewModel: InventoryViewModel = hiltViewModel()
) {
    val items by viewModel.inventoryItems.collectAsStateWithLifecycle()

    InventoryDialog(
        Modifier,
        items,
        showItem,
        onDismissRequest
    )
}
