package com.zenika.tutorial.presentation.parchment.end_parchment

import androidx.compose.runtime.Composable

@Composable
fun EndParchmentRoute(
    finishGame: () -> Unit
) {
    EndParchment(finishGame)
}