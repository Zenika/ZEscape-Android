package com.zenika.tutorial.presentation.home

import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TutorialHomeRoute(
    goBack: () -> Unit,
    goToScan: () -> Unit,
    viewModel: TutorialHomeViewModel = hiltViewModel()
) {
    BackHandler {
        viewModel.goBack()
    }

    val event by viewModel.events.collectAsStateWithLifecycle(initialValue = null)
    LaunchedEffect(event) {
        when (event) {
            TutorialHomeEvent.HOME -> goBack()
            null -> Unit
        }
    }

    TutorialHomeScreen(
        viewModel::goBack,
        goToScan
    )
}
