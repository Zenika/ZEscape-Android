package com.zenika.story.tutorial.domain

import com.zenika.R
import com.zenika.data.repository.ItemRepository
import javax.inject.Inject

class RemoveKeyFromInventoryUseCase @Inject constructor(
    private val itemRepository: ItemRepository
) {
    suspend operator fun invoke() {
        itemRepository.deleteItem("key", R.mipmap.key)
    }
}
