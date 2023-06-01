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
import com.zenika.tutorial.presentation.color_buttons_order_game.ColorButtonsOrderGameRoute
import com.zenika.tutorial.presentation.parchment.end_parchment.EndParchmentRoute
import com.zenika.tutorial.presentation.parchment.welcome_parchment.WelcomeParchmentRoute

private const val ROUTE_END_PARCHMENT = "endParchmentRoute"
private const val ROUTE_INSTRUCTION = "instructionRoute"
private const val ROUTE_INVENTORY = "inventoryRoute"
private const val ROUTE_INTRO = "intro"
private const val ROUTE_MAIN = "mainRoute"
private const val ROUTE_MINI_GAME = "miniGameRoute"
private const val ROUTE_WELCOME_PARCHMENT = "welcomeParchmentRoute"

private const val ROUTE_PATTERN_ITEM = "itemRoute/{item}"

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.tutorialNavigation(
    route: String,
    navController: NavHostController
) {
    navigation(
        route = route,
        startDestination = ROUTE_INTRO
    ) {
        composable(ROUTE_INTRO) {
            WelcomeParchmentRoute(
                openInstruction = {
                    navController.popBackStack()
                    navController.navigate(ROUTE_MAIN)
                    navController.navigate(ROUTE_INSTRUCTION)
                }
            )
        }
        dialog(ROUTE_INSTRUCTION) {
            InstructionRoute(
                onDismissRequest = {
                    navController.popBackStack()
                }
            )
        }
        composable(ROUTE_MAIN) {
            MainRoute(
                openMiniGame = {
                    navController.navigate(ROUTE_MINI_GAME)
                },
                openInventory = {
                    navController.navigate(ROUTE_INVENTORY)
                }
            )
        }
        dialog(ROUTE_MINI_GAME) {
            ColorButtonsOrderGameRoute(
                onDismissRequest = {
                    navController.popBackStack()
                }
            )
        }
        dialog(ROUTE_INVENTORY) {
            InventoryRoute(
                onDismissRequest = {
                    navController.popBackStack()
                },
                showItem = { item ->
                    navController.navigate(ROUTE_PATTERN_ITEM.replace("{item}", item.toString()))
                }
            )
        }
        composable(ROUTE_WELCOME_PARCHMENT) {
            WelcomeParchmentRoute(
                openInstruction = {
                    navController.popBackStack(route = ROUTE_MAIN, inclusive = false)
                }
            )
        }
        dialog(
            ROUTE_PATTERN_ITEM,
            arguments = listOf(navArgument("item") {
                type = NavType.IntType
            })
        ) {
            ItemRoute(
                onDismissRequest = {
                    navController.popBackStack()
                },
                openWelcomeParchment = {
                    navController.navigate(ROUTE_WELCOME_PARCHMENT)
                },
                openEndParchment = {
                    navController.navigate(ROUTE_END_PARCHMENT)
                }
            )
        }
        composable(ROUTE_END_PARCHMENT) {
            EndParchmentRoute(
                finishGame = {
                    navController.popBackStack()
                }
            )
        }
    }
}

