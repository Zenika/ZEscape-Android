package com.zenika.tutorial.presentation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.dialog
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.google.accompanist.navigation.animation.composable
import com.zenika.qrcode_scan.QrCodeScanRoute
import com.zenika.settings.SettingsRoute
import com.zenika.tutorial.presentation.color_buttons_order_game.ColorButtonsOrderGameRoute
import com.zenika.tutorial.presentation.hint.HintRoute
import com.zenika.tutorial.presentation.home.HomeRoute
import com.zenika.tutorial.presentation.instruction.InstructionRoute
import com.zenika.tutorial.presentation.inventory.InventoryRoute
import com.zenika.tutorial.presentation.item.ItemRoute
import com.zenika.tutorial.presentation.main.MainRoute
import com.zenika.tutorial.presentation.parchment.end_parchment.EndParchmentRoute
import com.zenika.tutorial.presentation.parchment.welcome_parchment.WelcomeParchmentRoute
import com.zenika.tutorial.presentation.penalty.PenaltyRoute
import com.zenika.tutorial.presentation.score.ScoreRoute

private const val ROUTE_HOME_TUTORIAL = "homeScreenTutorial"
private const val ROUTE_QRCODE_SCAN_TUTORIAL = "qrCodeScanTutorial"
private const val ROUTE_END_PARCHMENT = "endParchmentRouteTutorial"
private const val ROUTE_INSTRUCTION_TUTORIAL = "instructionRouteTutorial"
private const val ROUTE_INVENTORY_TUTORIAL = "inventoryRouteTutorial"
private const val ROUTE_INTRO_TUTORIAL = "introTutorial"
private const val ROUTE_MAIN = "mainRouteTutorial"
private const val ROUTE_MINI_GAME = "miniGameRouteTutorial"
private const val ROUTE_SCORE_TUTORIAL = "scoreRouteTutorial"
private const val ROUTE_SETTINGS_TUTORIAL = "settingsRouteTutorial"
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
        startDestination = ROUTE_HOME_TUTORIAL
    ) {
        composable(ROUTE_HOME_TUTORIAL) {
            HomeRoute(
                backToHome = { navController.popBackStack() },
                goToScan = { navController.navigate(ROUTE_QRCODE_SCAN_TUTORIAL) }
            )
        }
        composable(ROUTE_QRCODE_SCAN_TUTORIAL) {
            QrCodeScanRoute(
                backToPreviousScreen = { navController.popBackStack() },
                goToNextScreen = { navController.navigate(ROUTE_INTRO_TUTORIAL) }
            )
        }
        composable(ROUTE_INTRO_TUTORIAL) {
            WelcomeParchmentRoute(
                openInstruction = {
                    navController.popBackStack()
                    navController.navigate(ROUTE_MAIN)
                    navController.navigate(ROUTE_INSTRUCTION_TUTORIAL)
                }
            )
        }
        dialog(ROUTE_INSTRUCTION_TUTORIAL) {
            InstructionRoute(
                onDismissRequest = {
                    navController.popBackStack()
                }
            )
        }
        composable(ROUTE_MAIN) {
            MainRoute(
                goToSettings = {
                    navController.navigate(ROUTE_SETTINGS_TUTORIAL)
                },
                openMiniGame = {
                    navController.navigate(ROUTE_MINI_GAME)
                },
                openInventory = {
                    navController.navigate(ROUTE_INVENTORY_TUTORIAL)
                },
                showHint = {
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
        dialog(ROUTE_INVENTORY_TUTORIAL) {
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
                    navController.navigate(ROUTE_SCORE_TUTORIAL)
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
        composable(ROUTE_SCORE_TUTORIAL) {
            ScoreRoute(
                goToHome = {
                    navController.popBackStack(
                        route = ROUTE_HOME_TUTORIAL,
                        inclusive = true
                    )
                }
            )
        }
        composable(ROUTE_SETTINGS_TUTORIAL) {
            SettingsRoute(
                backToPreviousScreen = { navController.popBackStack() },
                backToHome = {
                    navController.popBackStack(
                        route = ROUTE_HOME_TUTORIAL,
                        inclusive = true
                    )
                }
            )
        }
    }
}
