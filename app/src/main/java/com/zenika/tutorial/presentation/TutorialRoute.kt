package com.zenika.tutorial.presentation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.dialog
import androidx.navigation.navArgument
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.zenika.R
import com.zenika.tutorial.domain.InventoryViewModel
import com.zenika.tutorial.domain.GameViewModel
import com.zenika.tutorial.presentation.component.GameDialog
import com.zenika.tutorial.presentation.component.InstructionDialog
import com.zenika.tutorial.presentation.component.inventory.InventoryDialog
import com.zenika.tutorial.presentation.component.inventory.ItemDialog
import com.zenika.tutorial.presentation.component.map.EndMap
import com.zenika.tutorial.presentation.component.map.WelcomeMap

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun TutorialRoute(
) {
    val gameViewModel = GameViewModel()
    val inventoryViewModel = InventoryViewModel()
    val navController = rememberAnimatedNavController()
    AnimatedNavHost(
        navController = navController,
        startDestination = "welcomeMap"
    ) {
        composable("welcomeMap") {
            WelcomeMap(
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
                viewModel = gameViewModel,
                openMiniGame = {
                    navController.navigate("miniGame")
                },
                openInventory = {
                    navController.navigate("inventory")
                },
                getMap = {
                    gameViewModel.updateMapState()
                    inventoryViewModel.addItem("map", R.mipmap.rolled_map)
                }
            )
        }
        dialog("miniGame") {
            GameDialog(
                gameViewModel,
                onDismissRequest = {
                    navController.popBackStack()
                }
            )
        }
        dialog("inventory") {
            InventoryDialog(
                inventoryViewModel,
                onDismissRequest = {
                    navController.popBackStack()
                },
                showItem = { item ->
                    navController.navigate("item/$item")
                }
            )
        }
        dialog(
            "item/{item}",
            arguments = listOf(navArgument("item") {
                type = NavType.IntType
            })
        ) {
            ItemDialog(
                onDismissRequest = {
                    navController.popBackStack()
                },
                openEndMap = {
                    navController.navigate("endMap")
                }
            )
        }
        composable("endMap") {
            EndMap(
                finishGame = {
                    navController.navigate("tutorialScreen")
                }
            )
        }
    }
}
