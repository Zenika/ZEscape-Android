package com.zenika.presentation.qrcodescan

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import com.zenika.R
import com.zenika.presentation.component.ReturnButton
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QrCodeScanScreen(
    qrcode: String,
    goBack: () -> Unit,
    onCodeScanned: (String) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.qr_code_scan),
                        Modifier
                            .fillMaxWidth()
                    )
                },
                navigationIcon = {
                    ReturnButton(goBack)
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { paddingValues ->
        QrCodeScanContent(
            modifier = Modifier.padding(paddingValues),
            qrcode = qrcode,
            onCodeScanned = onCodeScanned
        )
    }
}

@Composable
private fun QrCodeScanContent(
    qrcode: String,
    onCodeScanned: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    var hasCamPermission by remember {
        mutableStateOf(
            ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED
        )
    }
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { granted ->
            hasCamPermission = granted
        }
    )
    LaunchedEffect(Unit) {
        launcher.launch(Manifest.permission.CAMERA)
    }

    Scan(
        hasCamPermission,
        context,
        qrcode,
        onCodeScanned,
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black)
    )
}

@Composable
private fun Scan(
    hasCamPermission: Boolean,
    currentContext: Context,
    qrcode: String,
    onCodeScanned: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var code by remember {
        mutableStateOf("")
    }
    val lifecycleOwner = LocalLifecycleOwner.current
    val cameraProviderFuture = remember {
        ProcessCameraProvider.getInstance(currentContext)
    }

    Box(modifier) {
        if (hasCamPermission) {
            AndroidView(
                factory = { context ->
                    val previewView = PreviewView(context)
                    val preview = Preview.Builder().build()
                    val selector = CameraSelector.Builder()
                        .requireLensFacing(CameraSelector.LENS_FACING_BACK)
                        .build()
                    preview.setSurfaceProvider(previewView.surfaceProvider)
                    val imageAnalysis = ImageAnalysis.Builder()
                        .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
                        .build()
                    imageAnalysis.setAnalyzer(
                        ContextCompat.getMainExecutor(context),
                        QrCodeAnalyzer { result ->
                            code = result
                        }
                    )
                    try {
                        cameraProviderFuture.get().bindToLifecycle(
                            lifecycleOwner,
                            selector,
                            preview,
                            imageAnalysis
                        )
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                    previewView
                },
                modifier = Modifier.fillMaxSize()
            )
        }
        CheckValidationIcon(
            code,
            qrcode,
            modifier = Modifier.align(Alignment.Center)
        )
    }

    LaunchedEffect(code) {
        if (code == qrcode) {
            delay(1500)
            onCodeScanned(code)
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun CheckValidationIcon(
    code: String,
    qrcode: String,
    modifier: Modifier = Modifier
) {
    AnimatedVisibility(
        visible = code == qrcode,
        modifier = modifier,
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
}

@ScreenPreview
@Composable
private fun QrCodeScanScreenPreview() {
    ZEscapeThemePreview {
        QrCodeScanScreen(
            qrcode = "trigger-001",
            goBack = {},
            onCodeScanned = {}
        )
    }
}

