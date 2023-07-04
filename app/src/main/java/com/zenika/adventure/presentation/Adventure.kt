package com.zenika.adventure.presentation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.dialog
import androidx.navigation.compose.navigation
import com.google.accompanist.navigation.animation.composable
import com.zenika.adventure.presentation.computer.ComputerRoute
import com.zenika.adventure.presentation.home.AdventureHomeRoute
import com.zenika.adventure.presentation.instruction.AdventureInstructionRoute
import com.zenika.adventure.presentation.portal.PortalRoute
import com.zenika.presentation.qrcode_scan.QrCodeScanRoute
import com.zenika.presentation.settings.SettingsRoute

private const val ROUTE_HOME = "adventureHome"
private const val ROUTE_COMPUTER = "adventureComputer"
private const val ROUTE_QRCODE_SCAN = "adventureQrCodeScan"
private const val ROUTE_PORTAL = "adventurePortal"
private const val ROUTE_INSTRUCTION = "adventureInstruction"
private const val ROUTE_SETTINGS = "adventureSettings"

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
                goToSettings = { navController.navigate(ROUTE_SETTINGS) }
            )
        }
        composable(ROUTE_SETTINGS) {
            SettingsRoute(
                goBack = { navController.popBackStack() },
                goBackToHome = { navController.popBackStack(ROUTE_HOME, inclusive = true) }
            )
        }
    }
}
