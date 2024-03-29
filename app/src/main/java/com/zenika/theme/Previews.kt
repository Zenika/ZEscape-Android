package com.zenika.theme

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview

@MustBeDocumented
@Retention(AnnotationRetention.BINARY)
@Target(
    AnnotationTarget.FUNCTION
)
@Preview(device = Devices.NEXUS_5, name = "Light Small smartphone", uiMode = UI_MODE_NIGHT_NO)
@Preview(device = Devices.PIXEL_4_XL, name = "Dark Big smartphone", uiMode = UI_MODE_NIGHT_YES)
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
fun ZEscapeThemePreview(content: @Composable () -> Unit) {
    ZEscapeTheme {
        Surface(content = content)
    }
}
