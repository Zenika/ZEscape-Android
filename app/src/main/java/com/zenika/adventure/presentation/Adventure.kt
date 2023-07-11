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
import com.zenika.adventure.presentation.computer.ComputerRoute
import com.zenika.adventure.presentation.home.AdventureHomeRoute
import com.zenika.adventure.presentation.instruction.AdventureInstructionRoute
import com.zenika.adventure.presentation.portal.PortalRoute
import com.zenika.adventure.presentation.portal_message.PortalMessageRoute
import com.zenika.adventure.presentation.world_map.WorldMapRoute
import com.zenika.presentation.qrcode_scan.QrCodeScanRoute
import com.zenika.presentation.settings.SettingsRoute

private const val ROUTE_HOME = "adventureHome"
private const val ROUTE_COMPUTER = "adventureComputer"
private const val ROUTE_QRCODE_SCAN = "adventureQrCodeScan"
private const val ROUTE_PORTAL = "adventurePortal"
private const val ROUTE_INSTRUCTION = "adventureInstruction"
private const val ROUTE_SETTINGS = "adventureSettings"
private const val ROUTE_PORTAL_MESSAGE = "adventurePortalMessage"
private const val ROUTE_WORLD_MAP = "adventureWorldMap"
private const val ROUTE_AGENCY_RECOGNITION = "adventureAgencyRecognition"
private const val ROUTE_PATTERN_AGENCY_VALIDATION = "adventureAgencyValidation/{agency}"

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
                goToScan = { navController.navigate(ROUTE_QRCODE_SCAN) }
            )
        }
        composable(ROUTE_QRCODE_SCAN) {
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
                onDismissRequest = {
                    navController.popBackStack()
                }
            )
        }
        composable(ROUTE_PORTAL) {
            PortalRoute(
                goToSettings = { navController.navigate(ROUTE_SETTINGS) },
                accessToPortal = { navController.navigate(ROUTE_PORTAL_MESSAGE) },
                openWorldMap = { navController.navigate(ROUTE_WORLD_MAP) }
            )
        }
        dialog(ROUTE_PORTAL_MESSAGE) {
            PortalMessageRoute(
                onDismissRequest = {
                    navController.popBackStack()
                }
            )
        }
        composable(ROUTE_SETTINGS) {
            SettingsRoute(
                goBack = { navController.popBackStack() },
                goBackToHome = { navController.popBackStack(ROUTE_HOME, inclusive = true) }
            )
        }
        dialog(ROUTE_WORLD_MAP) {
            WorldMapRoute(
                onDismissRequest = {
                    navController.popBackStack()
                },
                openTextRecognition = {
                    navController.navigate(ROUTE_AGENCY_RECOGNITION)
                }
            )
        }
        composable(ROUTE_AGENCY_RECOGNITION) {
            AgencyRecognitionRoute(
                goBack = {
                    navController.popBackStack()
                },
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
                onDismissRequest = {
                    navController.popBackStack()
                },
                goBackToWorldMap = {
                    navController.navigate(ROUTE_WORLD_MAP) {
                        popUpTo(ROUTE_PATTERN_AGENCY_VALIDATION) { inclusive = true }
                    }
                }
            )
        }
    }
}
