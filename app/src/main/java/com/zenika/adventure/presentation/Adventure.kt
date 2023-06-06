package com.zenika.adventure.presentation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.dialog
import androidx.navigation.compose.navigation
import com.google.accompanist.navigation.animation.composable
import com.zenika.ROUTE_HOME
import com.zenika.adventure.presentation.computer.ComputerRoute
import com.zenika.adventure.presentation.home.HomeScreen
import com.zenika.adventure.presentation.instruction.InstructionRoute
import com.zenika.adventure.presentation.portal.PortalRoute
import com.zenika.qrcode_scan.QrCodeScanRoute
import com.zenika.settings.SettingsRoute

private const val ROUTE_HOME_ADVENTURE = "homeAdventure"
private const val ROUTE_COMPUTER = "computerRouteAdventure"
private const val ROUTE_QRCODE_SCAN_ADVENTURE = "qrCodeScanAdventure"
private const val ROUTE_PORTAL = "portalRouteAdventure"
private const val ROUTE_INSTRUCTION_ADVENTURE = "instructionRouteAdventure"
private const val ROUTE_SETTINGS_ADVENTURE = "settingsRouteAdventure"

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
            HomeScreen(
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
                backToHome = { navController.popBackStack() },
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
                goToSettings = { navController.navigate(ROUTE_SETTINGS_ADVENTURE) }
            )
        }
        composable(ROUTE_SETTINGS_ADVENTURE) {
            SettingsRoute(
                backToPreviousScreen = { navController.popBackStack() },
                backToHome = { navController.navigate(ROUTE_HOME) }
            )
        }
    }
}
