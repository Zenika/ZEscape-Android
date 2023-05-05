package com.zenika.tutorial.presentation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.dialog
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.zenika.tutorial.presentation.component.EndMap
import com.zenika.tutorial.presentation.component.GameDialog
import com.zenika.tutorial.presentation.component.InstructionDialog
import com.zenika.tutorial.presentation.component.WelcomeMap

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun TutorialRoute(
) {
    val viewModel = hiltViewModel<TutorialViewModel>()
    val mapViewModel = hiltViewModel<MapViewModel>()
    val navController = rememberAnimatedNavController()
    AnimatedNavHost(
        navController = navController,
        startDestination = "welcomeMap"
    ) {
        composable("welcomeMap") {
            WelcomeMap(
                mapViewModel,
                openInstruction = {
                    navController.navigate("tutorialScreen")
                    navController.navigate("instructionDialog")
                }
            )
        }
        dialog("instructionDialog") {
            InstructionDialog(
                onDismissRequest = {
                    navController.popBackStack()
                }
            )
        }
        composable("tutorialScreen") {
            TutorialScreen(
                Modifier.fillMaxSize(),
                viewModel,
                openMiniGame = {
                    navController.navigate("miniGame")
                },
                getMap = {
                    viewModel.updateMapState()
                    navController.navigate("endMap")
                }
            )
        }
        dialog("miniGame") {
            GameDialog(
                viewModel,
                onDismissRequest = {
                    navController.popBackStack()
                }
            )
        }
        composable("endMap") {
            EndMap(
                mapViewModel,
                finishGame = {
                    navController.navigate("tutorialScreen")
                }
            )
        }
    }
}
