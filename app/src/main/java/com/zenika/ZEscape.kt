package com.zenika

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.zenika.adventure.presentation.adventureNavigation
import com.zenika.presentation.home.HomeRoute
import com.zenika.tutorial.presentation.tutorialNavigation

private const val ROUTE_HOME = "home"
private const val ROUTE_ADVENTURE = "adventure"
private const val ROUTE_TUTORIAL = "tutorial"

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ZEscape() {
    val navController = rememberAnimatedNavController()
    AnimatedNavHost(
        navController = navController,
        startDestination = ROUTE_HOME
    ) {
        composable(ROUTE_HOME) {
            HomeRoute(
                goToTutorial = { navController.navigate(ROUTE_TUTORIAL) },
                goToAdventure = { navController.navigate(ROUTE_ADVENTURE) }
            )
        }
        tutorialNavigation(
            route = ROUTE_TUTORIAL,
            parentNavController = navController
        )
        adventureNavigation(
            route = ROUTE_ADVENTURE,
            navController = navController
        )
    }
}
