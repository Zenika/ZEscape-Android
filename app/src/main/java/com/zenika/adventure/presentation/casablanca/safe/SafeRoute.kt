package com.zenika.adventure.presentation.casablanca.safe

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun SafeRoute(
    onDismissRequest: () -> Unit,
    viewModel: SafeViewModel = hiltViewModel()
) {
    val code by viewModel.code.collectAsStateWithLifecycle()
    val event by viewModel.events.collectAsStateWithLifecycle(initialValue = null)
    LaunchedEffect(event) {
        when (event) {
            SafeEvent.DISMISS -> onDismissRequest()
            null -> Unit
        }
    }

    SafeDialog(
        onDismissRequest,
        code,
        viewModel::addNumber,
        viewModel::clearNumber,
        viewModel::checkCode
    )
}
