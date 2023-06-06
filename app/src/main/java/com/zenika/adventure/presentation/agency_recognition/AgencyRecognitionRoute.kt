package com.zenika.adventure.presentation.agency_recognition

import androidx.compose.runtime.Composable

@Composable
fun AgencyRecognitionRoute(
    backToPreviousScreen: () -> Unit,
    openValidationDialog: (String) -> Unit
) {
    AgencyRecognitionScreen(
        backToPreviousScreen,
        openValidationDialog
    )
}
