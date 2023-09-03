package com.zenika.adventure.presentation.montreal.meetingroom.code

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun MontrealCodeRoute(
    onDismissRequest: () -> Unit,
    goToOffice: () -> Unit,
    openPenalty: () -> Unit,
    viewModel: MontrealCodeViewModel = hiltViewModel()
) {
    val code by viewModel.code.collectAsStateWithLifecycle()
    val event by viewModel.events.collectAsStateWithLifecycle(initialValue = null)
    LaunchedEffect(event) {
        when (event) {
            MontrealCodeEvent.APPLY_PENALTY -> openPenalty()
            MontrealCodeEvent.GO_TO_OFFICE -> goToOffice()
            null -> Unit
        }
    }

    MontrealCodeDialog(
        onDismissRequest,
        code,
        viewModel::addNumber,
        viewModel::clearNumber,
        viewModel::checkCode
    )
}
