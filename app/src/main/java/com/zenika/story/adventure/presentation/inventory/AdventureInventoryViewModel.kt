package com.zenika.story.adventure.presentation.inventory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenika.R
import com.zenika.common.domain.Inventory
import com.zenika.common.domain.ObserveInventoryUseCase
import com.zenika.story.adventure.domain.ApplyPenaltyUseCase
import com.zenika.story.adventure.domain.RemoveItemFromInventoryUseCase
import com.zenika.story.adventure.domain.RemoveNewItemBadgeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AdventureInventoryViewModel @Inject constructor(
    observeInventory: ObserveInventoryUseCase,
    private val applyPenalty: ApplyPenaltyUseCase,
    private val removeItemFromInventory: RemoveItemFromInventoryUseCase,
    private val removeNewItemBadge: RemoveNewItemBadgeUseCase,
) : ViewModel() {

    private val _events = MutableSharedFlow<ItemEvent>()
    val events = _events.asSharedFlow()

    val inventory: StateFlow<Inventory> = observeInventory()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
            initialValue = Inventory.start()
        )

    fun init() {
        removeNewItemBadge()
    }

    fun onItemClick(item: Int) {
        viewModelScope.launch {
            when (item) {
                R.mipmap.hook -> onPenaltyItemClick("hook", item)
                R.mipmap.sword -> onPenaltyItemClick("sword", item)
                else -> _events.emit(ItemEvent.ShowItem(item))
            }
        }
    }

    private suspend fun onPenaltyItemClick(
        penaltyName: String,
        item: Int
    ) {
        removeItemFromInventory(penaltyName, item)
        applyPenalty()
        _events.emit(ItemEvent.OpenPenalty(penaltyName))
    }

}

sealed interface ItemEvent {
    class OpenPenalty(val penalty: String) : ItemEvent
    class ShowItem(val item: Int) : ItemEvent
}
