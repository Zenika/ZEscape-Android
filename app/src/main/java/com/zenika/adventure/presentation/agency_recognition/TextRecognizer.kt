package com.zenika.adventure.presentation.agency_recognition

import android.content.Context
import androidx.camera.mlkit.vision.MlKitAnalyzer
import androidx.camera.view.CameraController
import androidx.camera.view.LifecycleCameraController
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.core.content.ContextCompat
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.latin.TextRecognizerOptions
import kotlinx.coroutines.delay

@Composable
fun TextRecognizer(
    backToPreviousScreen: () -> Unit,
    openValidationDialog: (String) -> Unit,
    context: Context,
    cameraController: LifecycleCameraController
) {
    var agency by remember {
        mutableStateOf("")
    }

    val agenciesName = listOf(
        "PARIS",
        "MONTREAL",
        "CASABLANCA",
        "SINGAPOUR",
        "LYON",
        "NEW YORK",
        "TOKYO",
        "BRASILIA",
        "DAKAR",
        "SYDNEY"
    )

    val textRecognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)
    val mainExecutor = ContextCompat.getMainExecutor(context)
    val analyzer = MlKitAnalyzer(
        listOf(textRecognizer),
        CameraController.COORDINATE_SYSTEM_VIEW_REFERENCED,
        mainExecutor,
    ) { analyzerResult ->
        analyzerResult.getValue(textRecognizer)?.let { text ->
            agency = text.text
        }
    }
    cameraController.setImageAnalysisAnalyzer(
        mainExecutor,
        analyzer
    )

    LaunchedEffect(agency) {
        if (agency in agenciesName) {
            delay(500)
            backToPreviousScreen()
            openValidationDialog(agency)
        }
    }
}
