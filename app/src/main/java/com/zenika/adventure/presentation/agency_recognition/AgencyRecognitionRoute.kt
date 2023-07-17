package com.zenika.adventure.presentation.agency_recognition

import androidx.compose.runtime.Composable

@Composable
fun AgencyRecognitionRoute(
    goBack: () -> Unit,
    onTextRecognized: (String) -> Unit
) {
    AgencyRecognitionScreen(
        goBack,
        onTextRecognized
    )
}
