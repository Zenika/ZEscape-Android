package com.zenika.presentation.debug

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigation
import com.google.accompanist.navigation.animation.composable
import com.zenika.adventure.presentation.singapore.on_off_game.OnOffRoute
import com.zenika.data.Game
import com.zenika.presentation.qrcode_scan.QrCodeScanRoute
import kotlinx.collections.immutable.persistentListOf

private const val ROUTE_HOME = "adventureHome"
private const val ROUTE_QRCODE_SCAN = "adventureQrCodeScan"
private const val ROUTE_ON_OFF_GAME = "adventureOnOffGame"

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.debugNavigation(
    route: String,
    navController: NavHostController
) {
    navigation(
        route = route,
        startDestination = ROUTE_HOME
    ) {
        composable(ROUTE_HOME) {
            DebugRoute(
                goBack = { navController.popBackStack() },
                games = persistentListOf(
                    Game.ON_OFF to { navController.navigate(ROUTE_ON_OFF_GAME) }
                )
            )
        }
        composable(ROUTE_QRCODE_SCAN) {
            QrCodeScanRoute(
                goBack = { navController.popBackStack() },
                goToNextScreen = {}
            )
        }
        composable(ROUTE_ON_OFF_GAME) {
            OnOffRoute(
                winGame = { navController.popBackStack() },
                goToSettings = {}
            )
        }
    }
}
