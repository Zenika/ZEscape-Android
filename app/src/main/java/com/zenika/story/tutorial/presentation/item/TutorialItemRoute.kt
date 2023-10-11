package com.zenika.story.tutorial.presentation.item

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.zenika.R

@Composable
fun TutorialItemRoute(
    onDismissRequest: () -> Unit,
    openEndParchment: () -> Unit,
    openPenalty: (String) -> Unit,
    viewModel: TutorialItemViewModel = hiltViewModel()
) {
    val item by viewModel.item.collectAsStateWithLifecycle()

    when (val itemRes = item) {
        R.mipmap.key -> openPenalty("key")
        R.mipmap.rolled_map -> openEndParchment()
        null -> Unit
        else -> TutorialItemDialog(itemRes, onDismissRequest)
    }
}
