package com.zenika.tutorial.presentation.inventory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenika.R
import com.zenika.data.model.ItemDto
import com.zenika.data.repository.ItemRepository
import com.zenika.tutorial.domain.ObserveInventoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class InventoryViewModel @Inject constructor(
    private val itemRepository: ItemRepository,
    observeInventory: ObserveInventoryUseCase
) : ViewModel() {

    val inventoryItems: StateFlow<InventoryState> = observeInventory()
            .map { items -> InventoryState(items) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
                initialValue = InventoryState.start()
            )

    suspend fun addItem(itemName: String, itemRes: Int) {
        itemRepository.addItem(itemName, itemRes)
    }
}

data class InventoryState(
    val items: List<ItemDto>
) {
    companion object {
        fun start(): InventoryState = InventoryState(
            listOf(
                ItemDto(
                    "parchment",
                    R.mipmap.parchment
                ),
                ItemDto(
                    "paper",
                    R.mipmap.paper
                )
            )
        )
    }
}