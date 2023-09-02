package com.zenika.presentation.debug

import android.content.Intent
import android.net.Uri
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigation
import com.google.accompanist.navigation.animation.composable
import com.zenika.adventure.presentation.montreal.simonsays.SimonSaysRoute
import com.zenika.adventure.presentation.singapore.on_off_game.OnOffRoute
import com.zenika.data.Game
import com.zenika.presentation.qrcodescan.QrCodeScanRoute
import kotlinx.collections.immutable.persistentListOf

private const val ROUTE_HOME = "debugHome"
private const val ROUTE_QRCODE_SCAN = "debugQrCodeScan"
private const val ROUTE_ON_OFF_GAME = "debugOnOffGame"
private const val ROUTE_SIMON_SAYS = "debugSimonSays"

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
                    Game.ON_OFF to { navController.navigate(ROUTE_ON_OFF_GAME) },
                    Game.SIMON_SAYS to { navController.navigate(ROUTE_SIMON_SAYS) },
                    Game.CASABLANCA to {
                        navController.handleDeepLink(
                            deeplinkIntent("app://zescape/casablanca/outside")
                        )
                    },
                    Game.SINGAPORE to {
                        navController.handleDeepLink(
                            deeplinkIntent("app://zescape/singapore/outside")
                        )
                    },
                    Game.MONTREAL to {
                        navController.handleDeepLink(
                            deeplinkIntent("app://zescape/montreal/outside")
                        )
                    },
                )
            )
        }
        composable(ROUTE_QRCODE_SCAN) {
            QrCodeScanRoute(
                goBack = { navController.popBackStack() },
                onCodeScanned = {}
            )
        }
        composable(ROUTE_ON_OFF_GAME) {
            OnOffRoute(
                winGame = { navController.popBackStack() },
                openHintValidation = {},
                goToSettings = {}
            )
        }
        composable(ROUTE_SIMON_SAYS) {
            SimonSaysRoute(
                winGame = { navController.popBackStack() },
                openHintValidation = {},
                goToSettings = {}
            )
        }
    }
}

private fun deeplinkIntent(uri: String): Intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
