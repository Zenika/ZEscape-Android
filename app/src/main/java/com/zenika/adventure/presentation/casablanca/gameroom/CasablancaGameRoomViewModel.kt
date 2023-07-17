package com.zenika.adventure.presentation.casablanca.gameroom

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenika.R
import com.zenika.adventure.domain.CollectCasablancaPaperUseCase
import com.zenika.adventure.domain.GetCasablancaPaperStateUseCase
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
class CasablancaGameRoomViewModel @Inject constructor(
    private val itemRepository: ItemRepository,
    observeRemainingTime: ObserveRemainingTimeUseCase,
    getCasablancaPaperState: GetCasablancaPaperStateUseCase,
    private val collectCasablancaPaper: CollectCasablancaPaperUseCase
) : ViewModel() {
    val state: StateFlow<MeetingRoomUiState> = combine(
        getCasablancaPaperState(), observeRemainingTime()
    ) { casablancaPaperCollected, remainingTime ->
        MeetingRoomUiState(
            casablancaPaperCollected,
            remainingTime
        )
    }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
            initialValue = MeetingRoomUiState(
                casablancaPaperCollected = false,
                remainingTime = 0
            )
        )

    fun collectPaper() {
        viewModelScope.launch {
            itemRepository.addItem("casablancaPaper", R.mipmap.casablanca_code)
            collectCasablancaPaper()
        }
    }
}

class MeetingRoomUiState(
    val isCasablancaPaperCollected: Boolean,
    val remainingTime: Int
)
