package com.zenika.adventure.presentation.item

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun AdventureItemRoute(
    onDismissRequest: () -> Unit,
    viewModel: AdventureItemViewModel = hiltViewModel()
) {
    val item by viewModel.item.collectAsState()

    AdventureItemDialog(item, onDismissRequest)
}
