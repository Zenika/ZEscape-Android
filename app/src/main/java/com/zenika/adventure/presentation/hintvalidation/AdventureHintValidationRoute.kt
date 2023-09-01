package com.zenika.adventure.presentation.hintvalidation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun AdventureHintValidationRoute(
    onDismissRequest: () -> Unit,
    showHint: (String) -> Unit,
    viewModel: AdventureHintValidationViewModel = hiltViewModel()
) {
    val hint by viewModel.hint.collectAsStateWithLifecycle()

    LaunchedEffect(viewModel) {
        viewModel.events.collect { event ->
            when (event) {
                AdventureHintEvent.DISMISS -> onDismissRequest()
                AdventureHintEvent.SHOW_HINT -> showHint(hint)
            }
        }
    }

    AdventureHintValidationDialog(
        onDismissRequest,
        viewModel::dismissHint,
        viewModel::showHint
    )
}
