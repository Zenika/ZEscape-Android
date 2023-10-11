package com.zenika.story.adventure.domain

import com.zenika.data.state.AdventureGameStateManager
import javax.inject.Inject

class DiscoverMontrealOfficeUseCase @Inject constructor(
    private val gameStateManager: AdventureGameStateManager
) {
    operator fun invoke() {
        gameStateManager.discoverOffice()
    }
}
