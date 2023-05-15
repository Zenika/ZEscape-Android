package com.zenika.tutorial.presentation.inventory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenika.R
import com.zenika.data.model.ItemDto
import com.zenika.data.repository.ItemRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class InventoryViewModel @Inject constructor(
    private val itemRepository: ItemRepository
) : ViewModel() {

    private var _inventoryItems =
        MutableStateFlow(
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
    val inventoryItems: StateFlow<List<ItemDto>> = _inventoryItems
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
            initialValue = listOf(ItemDto("paper", R.mipmap.paper))
        )

    private fun getItems(): Flow<List<ItemDto>> {
        return itemRepository.getItems()
    }

    suspend fun addItem(itemName: String, itemRes: Int) {
        itemRepository.addItem(itemName, itemRes)
    }
}