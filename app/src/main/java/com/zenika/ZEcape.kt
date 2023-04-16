package com.zenika

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.zenika.feature1.presentation.Feature1Route
import com.zenika.feature2.presentation.Feature2Route

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ZEScape() {
    val navController = rememberAnimatedNavController()
    AnimatedNavHost(
        navController = navController,
        startDestination = "feature1"
    ) {
        composable("feature1") {
            Feature1Route(
                goToFeature2 = { navController.navigate("feature2") }
            )
        }
        composable("feature2") {
            Feature2Route()
        }
    }
}
