package com.zenika.adventure.domain

import com.zenika.data.state.AdventureGameStateManager
import javax.inject.Inject

class OpenMontrealDoorUseCase @Inject constructor(
    private val gameStateManager: AdventureGameStateManager
) {
    operator fun invoke() {
        gameStateManager.discoverOffice()
        gameStateManager.openMontrealDoor()
    }
}
