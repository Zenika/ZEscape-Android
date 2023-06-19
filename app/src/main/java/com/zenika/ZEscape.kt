package com.zenika

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.zenika.tutorial.presentation.tutorialNavigation

private const val ROUTE_TUTORIAL = "tutorial"

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ZEscape() {
    val navController = rememberAnimatedNavController()
    AnimatedNavHost(
        navController = navController,
        startDestination = ROUTE_TUTORIAL
    ) {
        tutorialNavigation(
            route = ROUTE_TUTORIAL,
            navController = navController
        )
    }
}
