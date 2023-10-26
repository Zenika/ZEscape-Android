package com.zenika.story.adventure.domain

import android.content.Context
import android.hardware.camera2.CameraManager
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class DisableFlashLightUseCase @Inject constructor(
    @ApplicationContext
    private val context: Context
) {
    operator fun invoke() {
        (context.getSystemService(Context.CAMERA_SERVICE) as CameraManager?)
            ?.let { cameraManager ->
                cameraManager.cameraIdList
                    .firstOrNull()
                    ?.let { cameraId -> cameraManager.setTorchMode(cameraId, false) }
            }
    }
}
