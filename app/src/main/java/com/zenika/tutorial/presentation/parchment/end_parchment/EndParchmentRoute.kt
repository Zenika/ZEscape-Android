package com.zenika.tutorial.presentation.parchment.end_parchment

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable

@Composable
fun EndParchmentRoute(
    goToScore: () -> Unit
) {
    BackHandler {
        // Player cannot leave the tutorial while it is running.
    }

    EndParchmentScreen(goToScore)
}