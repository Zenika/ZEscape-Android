package com.zenika.adventure.presentation.item

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ItemRoute(
    onDismissRequest: () -> Unit,
    viewModel: ItemViewModel = hiltViewModel()
) {
    val item by viewModel.item.collectAsState()

    ItemDialog(item, onDismissRequest)
}
