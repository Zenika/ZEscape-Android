package com.zenika.adventure.presentation.item

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.zenika.R
import com.zenika.adventure.presentation.item.component.KeyDialog

@Composable
fun AdventureItemRoute(
    onDismissRequest: () -> Unit,
    viewModel: AdventureItemViewModel = hiltViewModel()
) {
    val item by viewModel.item.collectAsStateWithLifecycle()

    when (val itemRes = item) {
        R.mipmap.singapore_key -> KeyDialog(onDismissRequest)
        null -> Unit
        else -> AdventureItemDialog(itemRes, onDismissRequest)
    }
}
