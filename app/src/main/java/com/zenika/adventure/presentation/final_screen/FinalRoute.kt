package com.zenika.adventure.presentation.final_screen

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable

@Composable
fun FinalRoute(goToScore: () -> Unit) {
    BackHandler {
        // Player cannot leave the adventure while it is running.
    }

    FinalScreen(goToScore)
}

