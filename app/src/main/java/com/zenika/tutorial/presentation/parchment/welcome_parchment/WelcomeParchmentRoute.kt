package com.zenika.tutorial.presentation.parchment.welcome_parchment

import androidx.compose.runtime.Composable

@Composable
fun WelcomeParchmentRoute(
    openInstruction: () -> Unit
) {
    WelcomeParchmentScreen(openInstruction)
}