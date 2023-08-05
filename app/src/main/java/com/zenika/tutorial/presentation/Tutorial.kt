package com.zenika.tutorial.presentation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.dialog
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.google.accompanist.navigation.animation.composable
import com.zenika.presentation.qrcodescan.QrCodeScanRoute
import com.zenika.presentation.settings.SettingsRoute
import com.zenika.tutorial.presentation.color_buttons_order_game.ColorButtonsOrderGameRoute
import com.zenika.tutorial.presentation.hint.TutorialHintRoute
import com.zenika.tutorial.presentation.home.TutorialHomeRoute
import com.zenika.tutorial.presentation.instruction.TutorialInstructionRoute
import com.zenika.tutorial.presentation.inventory.TutorialInventoryRoute
import com.zenika.tutorial.presentation.item.TutorialItemRoute
import com.zenika.tutorial.presentation.main.MainRoute
import com.zenika.tutorial.presentation.parchment.end_parchment.EndParchmentRoute
import com.zenika.tutorial.presentation.parchment.welcome_parchment.WelcomeParchmentRoute
import com.zenika.tutorial.presentation.penalty.TutorialPenaltyRoute
import com.zenika.tutorial.presentation.score.TutorialScoreRoute

private const val ROUTE_HOME = "tutorialHome"
private const val ROUTE_QRCODE_SCAN = "tutorialQrCodeScan/{qrcode}"
private const val ROUTE_END_PARCHMENT = "tutorialEndParchment"
private const val ROUTE_INSTRUCTION = "tutorialInstruction"
private const val ROUTE_INVENTORY = "tutorialInventory"
private const val ROUTE_INTRODUCTION = "tutorialIntroduction"
private const val ROUTE_MAIN = "tutorialMain"
private const val ROUTE_MINI_GAME = "tutorialMiniGame"
private const val ROUTE_SCORE = "tutorialScore"
private const val ROUTE_HINT = "tutorialHint"
private const val ROUTE_PATTERN_ITEM = "tutorialItem/{item}"
private const val ROUTE_PATTERN_PENALTY = "tutorialPenalty/{penalty}"
private const val ROUTE_SETTINGS = "tutorialSettings"

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
            TutorialHomeRoute(
                goBack = { navController.popBackStack() },
                goToScan = {
                    navController.navigate(
                        ROUTE_QRCODE_SCAN.replace(
                            "{qrcode}",
                            "trigger-001"
                        )
                    )
                }
            )
        }
        composable(
            ROUTE_QRCODE_SCAN,
            arguments = listOf(navArgument("qrcode") {
                type = NavType.StringType
            })
        ) {
            QrCodeScanRoute(
                goBack = { navController.popBackStack() },
                goToNextScreen = { navController.navigate(ROUTE_INTRODUCTION) }
            )
        }
        composable(ROUTE_INTRODUCTION) {
            WelcomeParchmentRoute(
                openInstruction = {
                    navController.popBackStack(ROUTE_HOME, inclusive = false)
                    navController.navigate(ROUTE_MAIN)
                    navController.navigate(ROUTE_INSTRUCTION)
                }
            )
        }
        dialog(ROUTE_INSTRUCTION) {
            TutorialInstructionRoute(
                onDismissRequest = { navController.popBackStack() }
            )
        }
        composable(ROUTE_MAIN) {
            MainRoute(
                goToSettings = { navController.navigate(ROUTE_SETTINGS) },
                openMiniGame = { navController.navigate(ROUTE_MINI_GAME) },
                openInventory = { navController.navigate(ROUTE_INVENTORY) },
                showHint = { navController.navigate(ROUTE_HINT) }
            )
        }
        dialog(ROUTE_MINI_GAME) {
            ColorButtonsOrderGameRoute(
                onDismissRequest = { navController.popBackStack() },
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
            TutorialHintRoute(
                onDismissRequest = { navController.popBackStack() }
            )
        }
        dialog(ROUTE_INVENTORY) {
            TutorialInventoryRoute(
                onDismissRequest = { navController.popBackStack() },
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
            TutorialItemRoute(
                onDismissRequest = { navController.popBackStack() },
                openEndParchment = { navController.navigate(ROUTE_END_PARCHMENT) },
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
                goToScore = { navController.navigate(ROUTE_SCORE) }
            )
        }
        dialog(
            ROUTE_PATTERN_PENALTY,
            arguments = listOf(navArgument("penalty") {
                type = NavType.StringType
            })
        ) {
            TutorialPenaltyRoute(
                onDismissRequest = {
                    navController.popBackStack(
                        route = ROUTE_MAIN,
                        inclusive = false
                    )
                }
            )
        }
        composable(ROUTE_SCORE) {
            TutorialScoreRoute(
                goBackToHome = {
                    navController.popBackStack(
                        route = ROUTE_HOME,
                        inclusive = true
                    )
                }
            )
        }
        composable(ROUTE_SETTINGS) {
            SettingsRoute(
                goBack = { navController.popBackStack() },
                goBackToHome = {
                    navController.popBackStack(
                        route = ROUTE_HOME,
                        inclusive = true
                    )
                }
            )
        }
    }
}
