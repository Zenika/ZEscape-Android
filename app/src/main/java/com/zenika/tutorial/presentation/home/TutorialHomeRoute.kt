package com.zenika.tutorial.presentation.home

import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TutorialHomeRoute(
    goBack: () -> Unit,
    goToScan: () -> Unit,
    viewModel: TutorialHomeViewModel = hiltViewModel()
) {
    BackHandler {
        // Player cannot leave the adventure while it is running.
    }

    LaunchedEffect(viewModel) {
        viewModel.events.collect { event ->
            when (event) {
                TutorialHomeEvent.HOME -> goBack()
            }
        }
    }

    TutorialHomeScreen(
        viewModel::goBack,
        goToScan
    )
}
