package com.zenika.tutorial.presentation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.dialog
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.google.accompanist.navigation.animation.composable
import com.zenika.tutorial.presentation.instruction.InstructionRoute
import com.zenika.tutorial.presentation.inventory.InventoryRoute
import com.zenika.tutorial.presentation.item.ItemRoute
import com.zenika.tutorial.presentation.main.MainRoute
import com.zenika.tutorial.presentation.mini_game.MiniGameRoute
import com.zenika.tutorial.presentation.parchment.end_parchment.EndParchmentRoute
import com.zenika.tutorial.presentation.parchment.welcome_parchment.WelcomeParchmentRoute

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.tutorialNavigation(
    route: String,
    navController: NavHostController
) {
    navigation(
        route = route,
        startDestination = "welcomeParchmentRoute"
    ) {
        composable("welcomeParchmentRoute") {
            WelcomeParchmentRoute(
                openInstruction = {
                    navController.navigate("mainRoute")
                    navController.navigate("instructionRoute")
                }
            )
        }
        dialog("instructionRoute") {
            InstructionRoute(
                onDismissRequest = {
                    navController.popBackStack()
                }
            )
        }
        composable("mainRoute") {
            MainRoute(
                openMiniGame = {
                    navController.navigate("miniGameRoute")
                },
                openInventory = {
                    navController.navigate("inventoryRoute")
                }
            )
        }
        dialog("miniGameRoute") {
            MiniGameRoute(
                onDismissRequest = {
                    navController.popBackStack()
                }
            )
        }
        dialog("inventoryRoute") {
            InventoryRoute(
                onDismissRequest = {
                    navController.popBackStack()
                },
                showItem = { item ->
                    navController.navigate("itemRoute/$item")
                }
            )
        }
        dialog(
            "itemRoute/{item}",
            arguments = listOf(navArgument("item") {
                type = NavType.IntType
            })
        ) {
            ItemRoute(
                onDismissRequest = {
                    navController.popBackStack()
                },
                openWelcomeParchment = {
                    navController.navigate("welcomeParchmentRoute")
                },
                openEndParchment = {
                    navController.navigate("endParchmentRoute")
                }
            )
        }
        composable("endParchmentRoute") {
            EndParchmentRoute(
                finishGame = {
                    navController.navigate("mainRoute")
                }
            )
        }
    }
}

