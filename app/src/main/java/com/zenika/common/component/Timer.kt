package com.zenika.common.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.zenika.theme.ComposablePreview
import com.zenika.theme.ZEscapeThemePreview

@Composable
fun Timer(
    timer: Int,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified
) {
    Text(
        text = timerConverter(timer),
        modifier = modifier,
        textAlign = TextAlign.Center,
        color = color
    )
}

private fun timerConverter(timer: Int): String {
    val minutes = timer / 60000
    val seconds = timer / 1000 % 60
    val secondsString = if (seconds in 0..9) {
        "0$seconds"
    } else {
        seconds.toString()
    }

    return "$minutes:$secondsString"
}

@ComposablePreview
@Composable
private fun TimerPreview() {
    ZEscapeThemePreview {
        Timer(13 * 60_000 + 47_000, Modifier)
    }
}
