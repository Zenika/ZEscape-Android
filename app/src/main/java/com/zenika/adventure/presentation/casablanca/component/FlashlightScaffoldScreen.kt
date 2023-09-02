package com.zenika.adventure.presentation.casablanca.component

import android.content.Context
import android.hardware.camera2.CameraManager
import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import androidx.compose.ui.unit.dp
import com.zenika.adventure.presentation.component.AdventureInventoryBag
import com.zenika.adventure.presentation.component.ContinentsMap
import com.zenika.presentation.component.SettingsButton
import com.zenika.presentation.component.Timer
import com.zenika.ui.theme.screenPadding

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlashlightScaffoldScreen(
    remainingTime: Int,
    goToSettings: () -> Unit,
    @DrawableRes
    background: Int,
    newItem: Boolean,
    openWorldMap: () -> Unit,
    openInventory: () -> Unit,
    modifier: Modifier = Modifier,
    navigationIcon: @Composable () -> Unit = {},
    content: @Composable (BoxScope.() -> Unit)? = null
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {
                    Timer(
                        remainingTime,
                        Modifier.fillMaxWidth()
                    )
                },
                navigationIcon = navigationIcon,
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
        FlashlightContent(
            paddingValues,
            background,
            content
        )
        BottomItems(
            newItem,
            openWorldMap,
            openInventory
        )
    }
}

@Composable
private fun FlashlightContent(
    paddingValues: PaddingValues,
    background: Int,
    content: @Composable (BoxScope.() -> Unit)? = null
) {
    var pointerOffset by remember {
        mutableStateOf(Offset(0f, 0f))
    }

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

    val colors = if (isFlashLightOn) {
        listOf(Color.Transparent, Color.Black)
    } else {
        listOf(Color.Black, Color.Black)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painterResource(background),
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
        CompositionLocalProvider(LocalContentColor provides Color.Black) {
            if (content != null && isFlashLightOn) {
                content()
            }
        }
    }
}

@Composable
private fun BottomItems(
    newItem: Boolean,
    openWorldMap: () -> Unit,
    openInventory: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
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
            newItem = newItem,
            openInventory = openInventory,
            modifier = Modifier
                .size(80.dp)
                .align(Alignment.BottomEnd)
        )
    }
}
