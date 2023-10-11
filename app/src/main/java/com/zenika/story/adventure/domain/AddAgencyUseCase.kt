package com.zenika.story.adventure.domain

import com.zenika.data.state.AdventureGameStateManager
import com.zenika.story.adventure.domain.model.Agency
import javax.inject.Inject

class AddAgencyUseCase @Inject constructor(
    private val gameStateManager: AdventureGameStateManager
) {
    operator fun invoke(agency: Agency) = gameStateManager.addAgency(agency)
}
