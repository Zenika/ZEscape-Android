package com.zenika.tutorial.presentation.item

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.zenika.R

@Composable
fun ItemRoute(
    viewModel: ItemViewModel = hiltViewModel(),
    onDismissRequest: () -> Unit,
    openEndMap: () -> Unit
) {
    val item by viewModel.item.collectAsState()
    if (item == R.mipmap.rolled_map) {
        openEndMap()
    } else {
        ItemDialog(item, onDismissRequest)
    }
}
