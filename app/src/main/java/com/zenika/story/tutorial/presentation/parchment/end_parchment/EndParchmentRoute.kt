package com.zenika.story.tutorial.presentation.parchment.end_parchment

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable

@Composable
fun EndParchmentRoute(
    goToScore: () -> Unit
) {
    BackHandler {
        // Player cannot return to tutorial when the game is finished.
    }

    EndParchmentScreen(goToScore)
}
