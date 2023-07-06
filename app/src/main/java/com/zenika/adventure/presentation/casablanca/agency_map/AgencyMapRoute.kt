package com.zenika.adventure.presentation.casablanca.agency_map

import androidx.compose.runtime.Composable

@Composable
fun AgencyMapRoute(
    onDismissRequest: () -> Unit,
    goToRestRoom: () -> Unit,
    goToKitchen: () -> Unit,
    goToOffices: () -> Unit,
    goToMeetingRoom: () -> Unit
) {
    AgencyMapDialog(
        onDismissRequest,
        goToRestRoom,
        goToKitchen,
        goToOffices,
        goToMeetingRoom
    )
}
