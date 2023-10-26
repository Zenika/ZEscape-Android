package com.zenika.story.adventure.presentation.casablanca.component

import android.hardware.camera2.CameraManager

class TorchListener(
    private val callback: (Boolean) -> Unit
) : CameraManager.TorchCallback() {
    override fun onTorchModeChanged(cameraId: String, enabled: Boolean) {
        super.onTorchModeChanged(cameraId, enabled)
        callback(enabled)
    }
}
