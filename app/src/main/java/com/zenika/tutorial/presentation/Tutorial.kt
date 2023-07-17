package com.zenika.tutorial.presentation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.dialog
import androidx.navigation.navArgument
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.zenika.presentation.qrcode_scan.QrCodeScanRoute
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
private const val ROUTE_QRCODE_SCAN = "tutorialQrCodeScan"
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
    parentNavController: NavHostController
) {
    composable(route) {
        TutorialTheme {
            val tutorialNavController = rememberAnimatedNavController()
            AnimatedNavHost(
                navController = tutorialNavController,
                startDestination = ROUTE_HOME
            ) {
                composable(ROUTE_HOME) {
                    TutorialHomeRoute(
                        goBack = { parentNavController.popBackStack() },
                        goToScan = { tutorialNavController.navigate(ROUTE_QRCODE_SCAN) }
                    )
                }
                composable(ROUTE_QRCODE_SCAN) {
                    QrCodeScanRoute(
                        goBack = { tutorialNavController.popBackStack() },
                        goToNextScreen = { tutorialNavController.navigate(ROUTE_INTRODUCTION) }
                    )
                }
                composable(ROUTE_INTRODUCTION) {
                    WelcomeParchmentRoute(
                        openInstruction = {
                            tutorialNavController.popBackStack(ROUTE_HOME, inclusive = false)
                            tutorialNavController.navigate(ROUTE_MAIN)
                            tutorialNavController.navigate(ROUTE_INSTRUCTION)
                        }
                    )
                }
                dialog(ROUTE_INSTRUCTION) {
                    TutorialInstructionRoute(
                        onDismissRequest = { tutorialNavController.popBackStack() }
                    )
                }
                composable(ROUTE_MAIN) {
                    MainRoute(
                        goToSettings = { tutorialNavController.navigate(ROUTE_SETTINGS) },
                        openMiniGame = { tutorialNavController.navigate(ROUTE_MINI_GAME) },
                        openInventory = { tutorialNavController.navigate(ROUTE_INVENTORY) },
                        showHint = { tutorialNavController.navigate(ROUTE_HINT) }
                    )
                }
                dialog(ROUTE_MINI_GAME) {
                    ColorButtonsOrderGameRoute(
                        onDismissRequest = { tutorialNavController.popBackStack() },
                        openPenalty = { game ->
                            tutorialNavController.navigate(
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
                        onDismissRequest = { tutorialNavController.popBackStack() }
                    )
                }
                dialog(ROUTE_INVENTORY) {
                    TutorialInventoryRoute(
                        onDismissRequest = { tutorialNavController.popBackStack() },
                        showItem = { item ->
                            tutorialNavController.navigate(
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
                        onDismissRequest = { tutorialNavController.popBackStack() },
                        openEndParchment = { tutorialNavController.navigate(ROUTE_END_PARCHMENT) },
                        openPenalty = { item ->
                            tutorialNavController.navigate(
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
                        goToScore = { tutorialNavController.navigate(ROUTE_SCORE) }
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
                            tutorialNavController.popBackStack(
                                route = ROUTE_MAIN,
                                inclusive = false
                            )
                        }
                    )
                }
                composable(ROUTE_SCORE) {
                    TutorialScoreRoute(
                        goBackToHome = { parentNavController.popBackStack() }
                    )
                }
                composable(ROUTE_SETTINGS) {
                    SettingsRoute(
                        goBack = { tutorialNavController.popBackStack() },
                        goBackToHome = { parentNavController.popBackStack() }
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.tutorialComposable(
    route: String,
    content: @Composable () -> Unit
) {
    composable(route) {
        TutorialTheme(content = content)
    }
}
