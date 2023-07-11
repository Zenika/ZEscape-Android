package com.zenika.adventure.presentation.agency_recognition

import android.content.Context
import androidx.camera.mlkit.vision.MlKitAnalyzer
import androidx.camera.view.CameraController
import androidx.camera.view.LifecycleCameraController
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.latin.TextRecognizerOptions
import com.zenika.R
import kotlinx.coroutines.delay

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun TextRecognizer(
    onTextRecognized: (String) -> Unit,
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
    AnimatedVisibility(
        visible = agency in agenciesName,
        enter = scaleIn()
    ) {
        Icon(
            imageVector = Icons.Filled.CheckCircle,
            modifier = Modifier
                .size(52.dp),
            contentDescription = stringResource(R.string.check),
            tint = Color.Green
        )
    }

    LaunchedEffect(agency) {
        if (agency in agenciesName) {
            delay(500)
            onTextRecognized(agency)
        }
    }
}
