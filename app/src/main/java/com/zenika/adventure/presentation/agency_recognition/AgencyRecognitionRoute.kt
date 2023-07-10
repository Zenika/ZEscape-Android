package com.zenika.adventure.presentation.agency_recognition

import androidx.compose.runtime.Composable

@Composable
fun AgencyRecognitionRoute(
    goBack: () -> Unit,
    openValidationDialog: (String) -> Unit
) {
    AgencyRecognitionScreen(
        goBack,
        openValidationDialog
    )
}
