package com.zenika.tutorial.presentation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.dialog
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.google.accompanist.navigation.animation.composable
import com.zenika.qrcode_scan.QrCodeScanScreen
import com.zenika.tutorial.presentation.color_buttons_order_game.ColorButtonsOrderGameRoute
import com.zenika.tutorial.presentation.hint.HintRoute
import com.zenika.tutorial.presentation.home.HomeScreen
import com.zenika.tutorial.presentation.instruction.InstructionRoute
import com.zenika.tutorial.presentation.inventory.InventoryRoute
import com.zenika.tutorial.presentation.item.ItemRoute
import com.zenika.tutorial.presentation.main.MainRoute
import com.zenika.tutorial.presentation.parchment.end_parchment.EndParchmentRoute
import com.zenika.tutorial.presentation.parchment.welcome_parchment.WelcomeParchmentRoute
import com.zenika.tutorial.presentation.penalty.PenaltyRoute
import com.zenika.tutorial.presentation.score.ScoreRoute

private const val ROUTE_HOME = "homeScreenTutorial"
private const val ROUTE_QRCODE_SCAN = "qrCodeScanTutorial"
private const val ROUTE_END_PARCHMENT = "endParchmentRouteTutorial"
private const val ROUTE_INSTRUCTION = "instructionRouteTutorial"
private const val ROUTE_INVENTORY = "inventoryRouteTutorial"
private const val ROUTE_INTRO = "introTutorial"
private const val ROUTE_MAIN = "mainRouteTutorial"
private const val ROUTE_MINI_GAME = "miniGameRouteTutorial"
private const val ROUTE_SCORE = "scoreRouteTutorial"
private const val ROUTE_HINT = "hintRouteTutorial"
private const val ROUTE_PATTERN_ITEM = "itemRouteTutorial/{item}"
private const val ROUTE_PATTERN_PENALTY = "penaltyRouteTutorial/{penalty}"

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.tutorialNavigation(
    route: String,
    navController: NavHostController
) {
    navigation(
        route = route,
        startDestination = ROUTE_HOME
    ) {
        composable(ROUTE_HOME) {
            HomeScreen(
                goToScan = { navController.navigate(ROUTE_QRCODE_SCAN) }
            )
        }
        composable(ROUTE_QRCODE_SCAN) {
            QrCodeScanScreen(
                goToTutorial = { navController.navigate(ROUTE_INTRO) }
            )
        }
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
                },
                showClue = {
                    navController.navigate(ROUTE_HINT)
                }
            )
        }
        dialog(ROUTE_MINI_GAME) {
            ColorButtonsOrderGameRoute(
                onDismissRequest = {
                    navController.popBackStack()
                },
                openPenalty = { game ->
                    navController.navigate(
                        ROUTE_PATTERN_PENALTY.replace(
                            "{penalty}",
                            game
                        )
                    )
                }
            )
        }
        dialog(ROUTE_HINT) {
            HintRoute(
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
                    navController.navigate(
                        ROUTE_PATTERN_ITEM.replace(
                            "{item}",
                            item.toString()
                        )
                    )
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
                openEndParchment = {
                    navController.navigate(ROUTE_END_PARCHMENT)
                },
                openPenalty = { item ->
                    navController.navigate(
                        ROUTE_PATTERN_PENALTY.replace(
                            "{penalty}",
                            item
                        )
                    )
                }
            )
        }
        composable(ROUTE_END_PARCHMENT) {
            EndParchmentRoute(
                goToScore = {
                    navController.navigate(ROUTE_SCORE)
                }
            )
        }
        dialog(
            ROUTE_PATTERN_PENALTY,
            arguments = listOf(navArgument("penalty") {
                type = NavType.StringType
            })
        ) {
            PenaltyRoute(
                onDismissRequest = {
                    navController.popBackStack(
                        route = ROUTE_MAIN,
                        inclusive = false
                    )
                }
            )
        }
        composable(ROUTE_SCORE) {
            ScoreRoute(
                goToHome = {
                    navController.popBackStack(
                        route = ROUTE_HOME,
                        inclusive = false
                    )
                }
            )
        }
    }
}
