package com.zenika.adventure.presentation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.dialog
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.google.accompanist.navigation.animation.composable
import com.zenika.adventure.presentation.agency_recognition.AgencyRecognitionRoute
import com.zenika.adventure.presentation.agency_validation.AgencyValidationRoute
import com.zenika.adventure.presentation.casablanca.agency.CasablancaAgencyDialog
import com.zenika.adventure.presentation.casablanca.agency.CasablancaAgencyRoute
import com.zenika.adventure.presentation.casablanca.instruction.InstructionCasablancaRoute
import com.zenika.adventure.presentation.casablanca.outside.CasablancaOutsideRoute
import com.zenika.adventure.presentation.computer.ComputerRoute
import com.zenika.adventure.presentation.home.AdventureHomeRoute
import com.zenika.adventure.presentation.instruction.AdventureInstructionRoute
import com.zenika.adventure.presentation.inventory.AdventureInventoryRoute
import com.zenika.adventure.presentation.item.AdventureItemRoute
import com.zenika.adventure.presentation.penalty.AdventurePenaltyRoute
import com.zenika.adventure.presentation.portal.PortalRoute
import com.zenika.adventure.presentation.portal_message.PortalMessageRoute
import com.zenika.adventure.presentation.score.AdventureScoreDialog
import com.zenika.adventure.presentation.score.AdventureScoreRoute
import com.zenika.adventure.presentation.singapore.agency.SingaporeAgencyDialog
import com.zenika.adventure.presentation.singapore.agency.SingaporeAgencyRoute
import com.zenika.adventure.presentation.singapore.instruction.InstructionSingaporeRoute
import com.zenika.adventure.presentation.singapore.on_off_game.OnOffRoute
import com.zenika.adventure.presentation.world_map.WorldMapRoute
import com.zenika.presentation.qrcodescan.QrCodeScanRoute
import com.zenika.presentation.settings.SettingsRoute

private const val ROUTE_HOME = "adventureHome"
private const val ROUTE_COMPUTER = "adventureComputer"
private const val ROUTE_QRCODE_SCAN = "adventureQrCodeScan/{qrcode}"
private const val ROUTE_PORTAL = "adventurePortal"
private const val ROUTE_INSTRUCTION = "adventureInstruction"
private const val ROUTE_SETTINGS = "adventureSettings"
private const val ROUTE_PORTAL_MESSAGE = "adventurePortalMessage"
private const val ROUTE_INVENTORY = "adventureInventory"
private const val ROUTE_PATTERN_ITEM = "adventureItem/{item}"
private const val ROUTE_WORLD_MAP = "adventureWorldMap"
private const val ROUTE_AGENCY_RECOGNITION = "adventureAgencyRecognition"
private const val ROUTE_PATTERN_AGENCY_VALIDATION = "adventureAgencyValidation/{agency}"
private const val ROUTE_SINGAPORE_INSTRUCTION = "adventureSingaporeInstruction"
private const val ROUTE_ON_OFF_GAME = "adventureOnOffGame"
private const val ROUTE_SINGAPORE_AGENCY = "adventureSingaporeAgency"
private const val ROUTE_SINGAPORE_AGENCY_DIALOG = "adventureSingaporeAgencyDialog"
private const val ROUTE_SCORE = "adventureScore"
private const val ROUTE_SCORE_DIALOG = "adventureScoreDialog"
private const val ROUTE_CASABLANCA_INSTRUCTION = "adventureCasablancaInstruction"
private const val ROUTE_CASABLANCA_OUTSIDE = "adventureCasablancaOutside"
private const val ROUTE_CASABLANCA_AGENCY = "adventureCasablancaAgency"
private const val ROUTE_CASABLANCA_AGENCY_DIALOG = "adventureCasablancaAgencyDialog"
private const val ROUTE_PATTERN_PENALTY = "adventurePenalty/{penalty}"

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.adventureNavigation(
    route: String,
    navController: NavHostController
) {
    navigation(
        route = route,
        startDestination = ROUTE_HOME
    ) {
        composable(ROUTE_HOME) {
            AdventureHomeRoute(
                goBack = { navController.popBackStack() },
                goToAdventure = { navController.navigate(ROUTE_COMPUTER) }
            )
        }
        composable(ROUTE_COMPUTER) {
            ComputerRoute(
                goBack = { navController.popBackStack() },
                goToScan = {
                    navController.navigate(
                        ROUTE_QRCODE_SCAN.replace(
                            "{qrcode}",
                            "trigger-002"
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
                goToNextScreen = {
                    navController.popBackStack(ROUTE_HOME, inclusive = false)
                    navController.navigate(ROUTE_PORTAL)
                    navController.navigate(ROUTE_INSTRUCTION)
                }
            )
        }
        dialog(ROUTE_INSTRUCTION) {
            AdventureInstructionRoute(
                onDismissRequest = { navController.popBackStack() }
            )
        }
        composable(ROUTE_PORTAL) {
            PortalRoute(
                goToSettings = { navController.navigate(ROUTE_SETTINGS) },
                accessToClosePortal = { navController.navigate(ROUTE_PORTAL_MESSAGE) },
                accessToOpenPortal = {
                    navController.navigate(ROUTE_SCORE)
                    navController.navigate(ROUTE_SCORE_DIALOG)
                },
                openWorldMap = { navController.navigate(ROUTE_WORLD_MAP) },
                openInventory = { navController.navigate(ROUTE_INVENTORY) }
            )
        }
        dialog(ROUTE_PORTAL_MESSAGE) {
            PortalMessageRoute(
                onDismissRequest = { navController.popBackStack() }
            )
        }
        composable(ROUTE_SETTINGS) {
            SettingsRoute(
                goBack = { navController.popBackStack() },
                goBackToHome = { navController.popBackStack(ROUTE_HOME, inclusive = true) }
            )
        }
        dialog(ROUTE_INVENTORY) {
            AdventureInventoryRoute(
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
            AdventureItemRoute(
                onDismissRequest = { navController.popBackStack() },
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
        dialog(
            ROUTE_PATTERN_PENALTY,
            arguments = listOf(navArgument("penalty") {
                type = NavType.StringType
            })
        ) {
            AdventurePenaltyRoute(
                onDismissRequest = { navController.popBackStack() },
                goBackToSingaporeAgency = {
                    navController.popBackStack(
                        ROUTE_SINGAPORE_AGENCY,
                        inclusive = false
                    )
                }
            )
        }
        dialog(ROUTE_WORLD_MAP) {
            WorldMapRoute(
                onDismissRequest = { navController.popBackStack() },

                openTextRecognition = { navController.navigate(ROUTE_AGENCY_RECOGNITION) },
                goBackToPortal = {
                    navController.popBackStack(route = ROUTE_PORTAL, inclusive = false)
                },
                goInsideSingaporeAgency = { navController.navigate(route = ROUTE_SINGAPORE_AGENCY) },
                openOnOffGame = {
                    navController.navigate(ROUTE_ON_OFF_GAME)
                    navController.navigate(ROUTE_SINGAPORE_INSTRUCTION)
                },
                goToCasablanca = {
                    navController.navigate(ROUTE_CASABLANCA_OUTSIDE)
                    navController.navigate(ROUTE_CASABLANCA_INSTRUCTION)
                }
            )
        }
        composable(ROUTE_AGENCY_RECOGNITION) {
            AgencyRecognitionRoute(
                goBack = { navController.popBackStack() },
                onTextRecognized = { agency ->
                    navController.navigate(
                        ROUTE_PATTERN_AGENCY_VALIDATION.replace(
                            "{agency}",
                            agency
                        )
                    ) {
                        popUpTo(ROUTE_AGENCY_RECOGNITION) { inclusive = true }
                    }
                },
            )
        }
        dialog(
            ROUTE_PATTERN_AGENCY_VALIDATION,
            arguments = listOf(navArgument("agency") {
                type = NavType.StringType
            })
        ) {
            AgencyValidationRoute(
                onDismissRequest = { navController.popBackStack() },
                goBackToWorldMap = {
                    navController.navigate(ROUTE_WORLD_MAP) {
                        popUpTo(ROUTE_PATTERN_AGENCY_VALIDATION) { inclusive = true }
                    }
                },
                openPenalty = { item ->
                    navController.navigate(
                        ROUTE_PATTERN_PENALTY.replace(
                            "{penalty}",
                            item
                        )
                    ) {
                        popUpTo(ROUTE_PATTERN_AGENCY_VALIDATION) { inclusive = true }
                    }
                }
            )
        }
        dialog(ROUTE_SINGAPORE_INSTRUCTION) {
            InstructionSingaporeRoute(
                onDismissRequest = { navController.popBackStack() }
            )
        }
        composable(ROUTE_ON_OFF_GAME) {
            OnOffRoute(
                winGame = {
                    navController.navigate(ROUTE_SINGAPORE_AGENCY) {
                        popUpTo(ROUTE_ON_OFF_GAME) {
                            inclusive = true
                        }
                    }
                    navController.navigate(ROUTE_SINGAPORE_AGENCY_DIALOG)
                },
                goToSettings = { navController.navigate(ROUTE_SETTINGS) }
            )
        }
        composable(ROUTE_SINGAPORE_AGENCY) {
            SingaporeAgencyRoute(
                goToSettings = { navController.navigate(ROUTE_SETTINGS) },
                openWorldMap = { navController.navigate(ROUTE_WORLD_MAP) },
                openInventory = { navController.navigate(ROUTE_INVENTORY) }
            )
        }
        dialog(ROUTE_SINGAPORE_AGENCY_DIALOG) {
            SingaporeAgencyDialog(
                onDismissRequest = { navController.popBackStack() }
            )
        }
        composable(ROUTE_SCORE) {
            AdventureScoreRoute(
                goBackToHome = {
                    navController.popBackStack(
                        route = ROUTE_HOME,
                        inclusive = true
                    )
                }
            )
        }
        dialog(ROUTE_SCORE_DIALOG) {
            AdventureScoreDialog(
                onDismissRequest = { navController.popBackStack() }
            )
        }
        dialog(ROUTE_CASABLANCA_INSTRUCTION) {
            InstructionCasablancaRoute(
                onDismissRequest = { navController.popBackStack() }
            )
        }
        composable(ROUTE_CASABLANCA_OUTSIDE) {
            CasablancaOutsideRoute(
                goToSettings = { navController.navigate(ROUTE_SETTINGS) },
                openWorldMap = { navController.navigate(ROUTE_WORLD_MAP) },
                openInventory = { navController.navigate(ROUTE_INVENTORY) },
                enterInAgency = {
                    navController.navigate(ROUTE_CASABLANCA_AGENCY)
                    navController.navigate(ROUTE_CASABLANCA_AGENCY_DIALOG)
                },
                openPenalty = { item ->
                    navController.navigate(
                        ROUTE_PATTERN_PENALTY.replace(
                            "{penalty}",
                            item
                        )
                    ) {
                        popUpTo(ROUTE_SINGAPORE_AGENCY) { inclusive = false }
                    }
                }
            )
        }
        composable(ROUTE_CASABLANCA_AGENCY) {
            CasablancaAgencyRoute(
                goToSettings = { navController.navigate(ROUTE_SETTINGS) },
                openWorldMap = { navController.navigate(ROUTE_WORLD_MAP) },
                openInventory = { navController.navigate(ROUTE_INVENTORY) }
            )
        }
        dialog(ROUTE_CASABLANCA_AGENCY_DIALOG) {
            CasablancaAgencyDialog(
                onDismissRequest = { navController.popBackStack() }
            )
        }
    }
}
