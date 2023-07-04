package com.zenika.adventure.presentation.home

import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdventureHomeRoute(
    goBack: () -> Unit,
    goToAdventure: () -> Unit,
    viewModel: AdventureHomeViewModel = hiltViewModel()
) {
    BackHandler {
        // Player cannot leave the adventure while it is running.
    }

    LaunchedEffect(viewModel) {
        viewModel.events.collect { event ->
            when (event) {
                AdventureHomeEvent.HOME -> goBack()
            }
        }
    }

    AdventureHomeScreen(
        viewModel::goBack,
        goToAdventure
    )
}
