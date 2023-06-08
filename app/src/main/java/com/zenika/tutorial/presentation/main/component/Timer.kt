package com.zenika.tutorial.presentation.main.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

@Composable
fun Timer(remainingTimer: Int) {
    Text(
        text = timerConverter(remainingTimer),
        Modifier
            .fillMaxWidth(),
        textAlign = TextAlign.Center
    )
}

private fun timerConverter(remainingTimer: Int): String {
    val minutes = remainingTimer / 60000
    val seconds = remainingTimer / 1000 % 60
    val secondsString = if (seconds in 0..9) {
        "0$seconds"
    } else {
        seconds.toString()
    }

    return "$minutes:$secondsString"
}