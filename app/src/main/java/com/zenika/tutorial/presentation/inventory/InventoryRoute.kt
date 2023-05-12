package com.zenika.tutorial.presentation.inventory

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun InventoryRoute(
    viewModel: InventoryViewModel = hiltViewModel(),
    onDismissRequest: () -> Unit,
    showItem: (Int) -> Unit
) {
    val items by viewModel.inventoryItems.collectAsState()
    InventoryDialog(
        Modifier
            .fillMaxWidth()
            .background(
                MaterialTheme.colorScheme.primaryContainer,
                MaterialTheme.shapes.extraLarge
            ),
        items,
        showItem,
        onDismissRequest
    )
}
