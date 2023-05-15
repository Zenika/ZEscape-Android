package com.zenika.tutorial.presentation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.dialog
import androidx.navigation.navArgument
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.zenika.tutorial.presentation.component.welcome_map.EndParchmentRoute
import com.zenika.tutorial.presentation.instruction.InstructionRoute
import com.zenika.tutorial.presentation.inventory.InventoryRoute
import com.zenika.tutorial.presentation.item.ItemRoute
import com.zenika.tutorial.presentation.main.MainRoute
import com.zenika.tutorial.presentation.mini_game.MiniGameRoute
import com.zenika.tutorial.presentation.parchment.welcome_parchment.WelcomeParchmentRoute

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Tutorial(
) {
    val navController = rememberAnimatedNavController()
    AnimatedNavHost(
        navController = navController,
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
