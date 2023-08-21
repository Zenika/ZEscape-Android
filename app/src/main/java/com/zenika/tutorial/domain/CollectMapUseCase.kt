package com.zenika.tutorial.domain

import com.zenika.R
import com.zenika.data.repository.ItemRepository
import com.zenika.data.state.TutorialGameStateManager
import javax.inject.Inject

class CollectMapUseCase @Inject constructor(
    private val gameStateManager: TutorialGameStateManager,
    private val itemRepository: ItemRepository,
) {
    suspend operator fun invoke() {
        gameStateManager.collectMap()
        itemRepository.addItem("map", R.mipmap.rolled_map)
    }
}
