package com.zenika.story.adventure.domain

import com.zenika.data.state.AdventureGameStateManager
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ObserveKeyCollectionUseCase @Inject constructor(
    private val gameStateManager: AdventureGameStateManager
) {
    operator fun invoke() = gameStateManager.state.map {
        KeyCollection(
            it.isSingaporeKeyCollected,
            it.isCasablancaKeyCollected
        )
    }
}

class KeyCollection(
    val isSingaporeKeyCollected: Boolean,
    val isCasablancaKeyCollected: Boolean
)
