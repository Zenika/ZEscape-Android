package com.zenika.utils

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.zenika.ui.theme.ZEscapeTheme

@MustBeDocumented
@Retention(AnnotationRetention.BINARY)
@Target(
    AnnotationTarget.FUNCTION
)
@Preview(device = Devices.NEXUS_5, name = "Small smartphone")
@Preview(device = Devices.PIXEL_4_XL, name = "Big smartphone")
annotation class ScreenPreview

@MustBeDocumented
@Retention(AnnotationRetention.BINARY)
@Target(
    AnnotationTarget.FUNCTION
)
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Preview(uiMode = UI_MODE_NIGHT_NO)
@Preview(uiMode = UI_MODE_NIGHT_NO, locale = "fr")
annotation class ComposablePreview

@Composable
fun ZEscapeThemePreview(content :@Composable () -> Unit) {
    ZEscapeTheme {
        Surface(content = content)
    }
}