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
import com.zenika.adventure.presentation.home.HomeRoute
import com.zenika.adventure.presentation.instruction.InstructionRoute
import com.zenika.adventure.presentation.portal.PortalRoute
import com.zenika.adventure.presentation.portal_message.PortalMessageRoute
import com.zenika.adventure.presentation.world_map.WorldMapRoute
import com.zenika.qrcode_scan.QrCodeScanRoute
import com.zenika.settings.SettingsRoute

private const val ROUTE_HOME_ADVENTURE = "homeAdventure"
private const val ROUTE_COMPUTER = "computerRouteAdventure"
private const val ROUTE_QRCODE_SCAN_ADVENTURE = "qrCodeScanAdventure"
private const val ROUTE_PORTAL = "portalRouteAdventure"
private const val ROUTE_PORTAL_MESSAGE = "portalMessageRouteAdventure"
private const val ROUTE_INSTRUCTION_ADVENTURE = "instructionRouteAdventure"
private const val ROUTE_SETTINGS_ADVENTURE = "settingsRouteAdventure"
private const val ROUTE_WORLD_MAP = "worldMapRouteAdventure"
private const val ROUTE_AGENCY_RECOGNITION = "agencyRecognitionRouteAdventure"
private const val ROUTE_PATTERN_AGENCY_VALIDATION = "agencyValidationRouteAdventure{agency}"

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.adventureNavigation(
    route: String,
    navController: NavHostController
) {
    navigation(
        route = route,
        startDestination = ROUTE_HOME_ADVENTURE
    ) {
        composable(ROUTE_HOME_ADVENTURE) {
            HomeRoute(
                backToHome = { navController.popBackStack() },
                goToAdventure = { navController.navigate(ROUTE_COMPUTER) }
            )
        }
        composable(ROUTE_COMPUTER) {
            ComputerRoute(
                backToPreviousScreen = { navController.popBackStack() },
                goToScan = { navController.navigate(ROUTE_QRCODE_SCAN_ADVENTURE) }
            )
        }
        composable(ROUTE_QRCODE_SCAN_ADVENTURE) {
            QrCodeScanRoute(
                backToPreviousScreen = { navController.popBackStack() },
                goToNextScreen = {
                    navController.navigate(ROUTE_PORTAL)
                    navController.navigate(ROUTE_INSTRUCTION_ADVENTURE)
                }
            )
        }
        dialog(ROUTE_INSTRUCTION_ADVENTURE) {
            InstructionRoute(
                onDismissRequest = {
                    navController.popBackStack()
                }
            )
        }
        composable(ROUTE_PORTAL) {
            PortalRoute(
                goToSettings = { navController.navigate(ROUTE_SETTINGS_ADVENTURE) },
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
        composable(ROUTE_SETTINGS_ADVENTURE) {
            SettingsRoute(
                backToPreviousScreen = { navController.popBackStack() },
                backToHome = { navController.popBackStack(ROUTE_HOME_ADVENTURE, inclusive = true) }
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
                backToPreviousScreen = {
                    navController.popBackStack()
                },
                openValidationDialog = { agency ->
                    navController.navigate(
                        ROUTE_PATTERN_AGENCY_VALIDATION.replace(
                            "{agency}",
                            agency
                        )
                    )
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
                    navController.navigate(ROUTE_WORLD_MAP)
                }
            )
        }
    }
}
