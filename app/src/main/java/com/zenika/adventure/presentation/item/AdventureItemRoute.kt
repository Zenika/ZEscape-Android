package com.zenika.adventure.presentation.item

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun AdventureItemRoute(
    onDismissRequest: () -> Unit,
    viewModel: AdventureItemViewModel = hiltViewModel()
) {
    val item by viewModel.item.collectAsStateWithLifecycle()

    when (val itemRes = item) {
        null -> Unit
        else -> AdventureItemDialog(itemRes, onDismissRequest)
    }
}
