package com.zenika.adventure.presentation.home

import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AdventureHomeRoute(
    goBack: () -> Unit,
    goToAdventure: () -> Unit,
    viewModel: AdventureHomeViewModel = hiltViewModel()
) {
    BackHandler {
        goBack()
    }

    val event by viewModel.events.collectAsStateWithLifecycle(initialValue = null)
    LaunchedEffect(event) {
        when (event) {
            AdventureHomeEvent.HOME -> goBack()
            null -> Unit
        }
    }

    AdventureHomeScreen(
        viewModel::goBack,
        goToAdventure
    )
}
