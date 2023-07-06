package com.zenika.adventure.presentation.item

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenika.R
import com.zenika.adventure.domain.ApplyPenaltyUseCase
import com.zenika.data.repository.ItemRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AdventureItemViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val itemRepository: ItemRepository,
    private val applyPenaltyUseCase: ApplyPenaltyUseCase
) : ViewModel() {
    private var itemRes: Int =
        savedStateHandle.get<Int>("item") ?: error("Item is required")

    private var _item = MutableStateFlow(itemRes)
    val item: StateFlow<Int?> = _item
        .onEach {
            when (it) {
                R.mipmap.hook -> {
                    applyPenalty("hook", R.mipmap.hook)
                }
                R.mipmap.sword -> {
                    applyPenalty("sword", R.mipmap.sword)
                }
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
            initialValue = null
        )

    private fun applyPenalty(item: String, itemRes: Int) {
        deleteItemFromInventory(item, itemRes)
        applyPenaltyUseCase()
    }

    private fun deleteItemFromInventory(item: String, itemRes: Int) {
        viewModelScope.launch {
            itemRepository.deleteItem(item, itemRes)
        }
    }
}
