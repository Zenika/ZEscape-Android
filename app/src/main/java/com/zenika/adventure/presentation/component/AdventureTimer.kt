package com.zenika.adventure.presentation.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.zenika.utils.ComposablePreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun AdventureTimer(
    timer: Int,
    modifier: Modifier
) {
    Text(
        text = timerConverter(timer),
        modifier = modifier,
        textAlign = TextAlign.Center
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
private fun AdventureTimerPreview() {
    ZEscapeThemePreview {
        AdventureTimer(13 * 60_000 + 47_000, Modifier)
    }
}
