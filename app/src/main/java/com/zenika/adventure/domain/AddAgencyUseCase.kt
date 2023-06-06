package com.zenika.adventure.domain

import com.zenika.data.Agency
import com.zenika.data.state.AdventureGameStateManager
import javax.inject.Inject

class AddAgencyUseCase @Inject constructor(
    private val gameStateManager: AdventureGameStateManager
) {
    operator fun invoke(agency: Agency) = gameStateManager.addAgency(agency)
}
