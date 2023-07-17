package com.zenika.adventure.presentation.casablanca.agency

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@RequiresApi(Build.VERSION_CODES.M)
@Composable
fun CasablancaAgencyRoute(
    goToSettings: () -> Unit,
    openWorldMap: () -> Unit,
    openInventory: () -> Unit,
    openAgencyMap: () -> Unit,
    viewModel: CasablancaAgencyViewModel = hiltViewModel()
) {
    val remainingTime by viewModel.remainingTime.collectAsStateWithLifecycle()

    CasablancaAgencyScreen(
        remainingTime,
        goToSettings,
        openWorldMap,
        openInventory,
        openAgencyMap
    )
}

