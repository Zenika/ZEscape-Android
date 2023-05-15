package com.zenika

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.zenika.qrcode_scan.presentation.QrCodeScanScreen
import com.zenika.tutorial.presentation.Tutorial

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ZEscape() {
    val navController = rememberAnimatedNavController()
    AnimatedNavHost(
        navController = navController,
        startDestination = "qrCodeScanner"
    ) {
        composable("qrCodeScanner") {
            QrCodeScanScreen(
                goToTutorial = { navController.navigate("tutorial") }
            )
        }
        composable("tutorial") {
            Tutorial()
        }
    }
}
