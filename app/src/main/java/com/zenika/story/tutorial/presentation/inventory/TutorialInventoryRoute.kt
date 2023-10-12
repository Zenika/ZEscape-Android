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
    val inventory by viewModel.inventory.collectAsStateWithLifecycle()

    TutorialInventoryDialog(
        Modifier,
        inventory,
        showItem,
        onDismissRequest
    )
}
