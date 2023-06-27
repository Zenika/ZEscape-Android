package com.zenika.adventure.presentation.singapore.agency

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenika.R
import com.zenika.adventure.domain.CollectHookUseCase
import com.zenika.adventure.domain.CollectSingaporeKeyUseCase
import com.zenika.adventure.domain.CollectSwordUseCase
import com.zenika.adventure.domain.ObserveAdventureStateUseCase
import com.zenika.adventure.domain.ObserveRemainingTimeUseCase
import com.zenika.data.repository.ItemRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SingaporeAgencyViewModel @Inject constructor(
    private val itemRepository: ItemRepository,
    observeAdventureState: ObserveAdventureStateUseCase,
    observeRemainingTime: ObserveRemainingTimeUseCase,
    private val collectSingaporeKey: CollectSingaporeKeyUseCase,
    private val collectSwordItem: CollectSwordUseCase,
    private val collectHookItem: CollectHookUseCase
) : ViewModel() {

    val state: StateFlow<SingaporeUiState> = combine(
        observeAdventureState(), observeRemainingTime()
    ) { gameState, remainingTime ->
        SingaporeUiState(
            gameState.collectSingaporeKey,
            gameState.collectSword,
            gameState.collectHook,
            remainingTime
        )
    }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
            initialValue = SingaporeUiState(
                collectSingaporeKey = false,
                collectSword = false,
                collectHook = false,
                remainingTime = 3_600_600
            )
        )

    fun collectKey() {
        viewModelScope.launch {
            itemRepository.addItem("singaporeKey", R.mipmap.singapore_key)
            collectSingaporeKey()
        }
    }

    fun collectSword() {
        viewModelScope.launch {
            itemRepository.addItem("sword", R.mipmap.sword)
            collectSwordItem()
        }
    }

    fun collectHook() {
        viewModelScope.launch {
            itemRepository.addItem("hook", R.mipmap.hook)
            collectHookItem()
        }
    }
}

class SingaporeUiState(
    val collectSingaporeKey: Boolean,
    val collectSword: Boolean,
    val collectHook: Boolean,
    val remainingTime: Int
)
