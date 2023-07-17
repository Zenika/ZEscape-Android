package com.zenika.adventure.presentation.casablanca.agency

import android.content.Context
import android.hardware.camera2.CameraManager
import android.os.Build.VERSION_CODES.M
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.paint
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.zenika.R
import com.zenika.adventure.presentation.casablanca.component.CasablancaMap
import com.zenika.adventure.presentation.component.AdventureInventoryBag
import com.zenika.adventure.presentation.component.ContinentsMap
import com.zenika.presentation.component.SettingsButton
import com.zenika.presentation.component.Timer
import com.zenika.ui.theme.screenPadding
import com.zenika.adventure.presentation.casablanca.component.FlashlightScaffoldScreen
import com.zenika.adventure.presentation.component.CasablancaMap
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@RequiresApi(M)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CasablancaAgencyScreen(
    remainingTime: Int,
    goToSettings: () -> Unit,
    openWorldMap: () -> Unit,
    openInventory: () -> Unit,
    openAgencyMap: () -> Unit,
    modifier: Modifier = Modifier
) {
    FlashlightScaffoldScreen(
        modifier = modifier,
        remainingTime = remainingTime,
        goToSettings = goToSettings,
        background = R.mipmap.casablanca_agency,
        openWorldMap = openWorldMap,
        openInventory = openInventory
    ) {
        CasablancaMap(
            modifier = Modifier
                .size(100.dp)
                .align(Alignment.CenterEnd)
                .clickable(
                    interactionSource = MutableInteractionSource(),
                    indication = null,
                    onClick = openAgencyMap
                )
        )


    var isFlashLightOn by remember {
        mutableStateOf(false)
    }

    val context = LocalContext.current
    val cameraManager = context.getSystemService(Context.CAMERA_SERVICE) as CameraManager

    val torchCallback: CameraManager.TorchCallback =
    object : CameraManager.TorchCallback() {
        override fun onTorchModeChanged(cameraId: String, enabled: Boolean) {
            super.onTorchModeChanged(cameraId, enabled)
            isFlashLightOn = enabled
        }
    }
    cameraManager.registerTorchCallback(torchCallback, null)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Timer(
                        remainingTime,
                        Modifier.fillMaxWidth()
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.Search, stringResource(R.string.hint))
                    }
                },
                actions = {
                    SettingsButton(goToSettings)
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { paddingValues ->
        val colors = if (isFlashLightOn) {
            listOf(Color.Transparent, Color.Black)
        } else {
            listOf(Color.Black, Color.Black)
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .paint(
                    painterResource(R.mipmap.casablanca_agency),
                    contentScale = ContentScale.Crop
                )
                .pointerInput("dragging") {
                    detectDragGestures { _, dragAmount ->
                        pointerOffset += dragAmount
                    }
                }
                .onSizeChanged {
                    pointerOffset = Offset(it.width / 2f, it.height / 2f)
                }
                .drawWithContent {
                    drawContent()
                    drawRect(
                        Brush.radialGradient(
                            colors,
                            center = pointerOffset,
                            radius = 100.dp.toPx(),
                        )
                    )
                }
                .padding(paddingValues)
                .padding(screenPadding)
        ) {
            if (isFlashLightOn) {
                CasablancaMap(
                    modifier = Modifier
                        .size(100.dp)
                        .align(Alignment.CenterEnd)
                        .clickable(
                            interactionSource = MutableInteractionSource(),
                            indication = null,
                            onClick = openAgencyMap
                        )
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(screenPadding),
            contentAlignment = Alignment.Center
        ) {
            ContinentsMap(
                modifier = Modifier
                    .size(80.dp)
                    .align(Alignment.BottomStart)
                    .clickable { openWorldMap() }
            )
            AdventureInventoryBag(
                modifier = Modifier
                    .size(80.dp)
                    .align(Alignment.BottomEnd)
                    .clickable { openInventory() }
            )
        }
    }
}

@RequiresApi(M)
@ScreenPreview
@Composable
private fun CasablancaAgencyScreenPreview() {
    ZEscapeThemePreview {
        CasablancaAgencyScreen(
            remainingTime = 3_600,
            goToSettings = {},
            openWorldMap = {},
            openInventory = {},
            openAgencyMap = {}
        )
    }
}

