package com.zenika.presentation.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.zenika.utils.ComposablePreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun TutorialTimer(
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
<<<<<<<< HEAD:app/src/main/java/com/zenika/presentation/component/Timer.kt
private fun TimerPreview() {
========
private fun TutorialTimerPreview() {
>>>>>>>> 419cbb9 (Fix from review):app/src/main/java/com/zenika/tutorial/presentation/component/TutorialTimer.kt
    ZEscapeThemePreview {
        TutorialTimer(13 * 60_000 + 47_000, Modifier)
    }
}
