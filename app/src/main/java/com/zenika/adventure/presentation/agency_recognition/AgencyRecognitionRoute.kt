package com.zenika.adventure.presentation.agency_recognition

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun AgencyRecognitionRoute(
    backToPreviousScreen: () -> Unit,
    openValidationDialog: (String) -> Unit,
    viewModel: AgencyRecognitionViewModel = hiltViewModel()
) {
    val agencies by viewModel.agencies.collectAsState()

    AgencyRecognitionScreen(
        backToPreviousScreen,
        openValidationDialog,
        agencies
    )
}
