package com.zenika.tutorial.presentation.inventory

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.zenika.ui.theme.inventoryPadding

@Composable
fun InventoryRoute(
    viewModel: InventoryViewModel = hiltViewModel(),
    onDismissRequest: () -> Unit,
    showItem: (Int) -> Unit
) {
    val items by viewModel.inventoryItems.collectAsStateWithLifecycle()

    InventoryDialog(
        Modifier
            .padding(
                vertical = inventoryPadding
            )
            .fillMaxSize()
            .background(
                MaterialTheme.colorScheme.primaryContainer,
                MaterialTheme.shapes.extraLarge
            ),
        items,
        showItem,
        onDismissRequest
    )
}
