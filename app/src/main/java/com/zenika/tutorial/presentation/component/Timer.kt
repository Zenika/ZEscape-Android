package com.zenika.tutorial.presentation.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

@Composable
fun Timer(
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