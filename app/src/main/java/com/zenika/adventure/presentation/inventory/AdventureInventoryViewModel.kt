package com.zenika.adventure.presentation.inventory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenika.R
import com.zenika.adventure.domain.ApplyPenaltyUseCase
import com.zenika.adventure.domain.ObserveInventoryUseCase
import com.zenika.adventure.domain.RemoveItemFromInventoryUseCase
import com.zenika.data.state.InventoryState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AdventureInventoryViewModel @Inject constructor(
    observeInventory: ObserveInventoryUseCase,
    private val applyPenalty: ApplyPenaltyUseCase,
    private val removeItemFromInventory: RemoveItemFromInventoryUseCase
) : ViewModel() {

    private val _event = MutableSharedFlow<ItemEvent>()
    val event = _event.asSharedFlow()

    fun onItemClick(item: Int) {
        viewModelScope.launch {
            when (item) {
                R.mipmap.hook -> onPenaltyItemClick("hook", item)
                R.mipmap.sword -> onPenaltyItemClick("sword", item)
                else -> _event.emit(ItemEvent.ShowItem(item))
            }
        }
    }

    val inventoryItems: StateFlow<InventoryState> = observeInventory()
        .map { items -> InventoryState(items) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
            initialValue = InventoryState.start()
        )

    private suspend fun onPenaltyItemClick(
        penaltyName: String,
        item: Int
    ) {
        removeItemFromInventory(penaltyName, item)
        applyPenalty()
        _event.emit(ItemEvent.OpenPenalty(penaltyName))
    }

}

sealed interface ItemEvent {
    class OpenPenalty(val penalty: String) : ItemEvent
    class ShowItem(val item: Int) : ItemEvent
    object None : ItemEvent
}
