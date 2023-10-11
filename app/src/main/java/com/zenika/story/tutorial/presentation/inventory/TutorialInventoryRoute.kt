package com.zenika.story.tutorial.presentation.inventory

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun TutorialInventoryRoute(
    onDismissRequest: () -> Unit,
    showItem: (Int) -> Unit,
    viewModel: TutorialInventoryViewModel = hiltViewModel()
) {
    val items by viewModel.inventoryItems.collectAsStateWithLifecycle()

    TutorialInventoryDialog(
        Modifier,
        items,
        showItem,
        onDismissRequest
    )
}
