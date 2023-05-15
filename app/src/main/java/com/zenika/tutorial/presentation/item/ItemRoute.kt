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
    openWelcomeParchment: () -> Unit,
    openEndParchment: () -> Unit
) {
    val item by viewModel.item.collectAsState()
    when (item) {
        R.mipmap.parchment -> {
            openWelcomeParchment()
        }
        R.mipmap.rolled_map -> {
            openEndParchment()
        }
        else -> {
            ItemDialog(item, onDismissRequest)
        }
    }
}
