package com.zenika.story.adventure.domain

import com.zenika.story.adventure.data.AdventureGameStateManager
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ObserveKeyCollectionUseCase @Inject constructor(
    private val gameStateManager: AdventureGameStateManager
) {
    operator fun invoke() = gameStateManager.state.map {
        KeyCollection(
            isSingaporeKeyCollected = it.isSingaporeKeyCollected,
            isCasablancaKeyCollected = it.isCasablancaKeyCollected,
            isMontrealKeyCollected = it.isMontrealKeyCollected,
        )
    }
}

class KeyCollection(
    val isSingaporeKeyCollected: Boolean,
    val isCasablancaKeyCollected: Boolean,
    val isMontrealKeyCollected: Boolean,
)
