package com.zenika

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.zenika.tutorial.presentation.TutorialRoute

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ZEscape() {
    val navController = rememberAnimatedNavController()
    AnimatedNavHost(
        navController = navController,
        startDestination = "tutorial"
    ) {
        composable("tutorial") {
            TutorialRoute()
        }
    }
}
