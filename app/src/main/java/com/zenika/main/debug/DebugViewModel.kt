package com.zenika.main.debug

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenika.story.adventure.domain.FinishGameUseCase
import com.zenika.story.adventure.domain.RestartAdventureGameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DebugViewModel @Inject constructor(
    private val restartAdventureGame: RestartAdventureGameUseCase,
    private val finishGameUseCase: FinishGameUseCase
) : ViewModel() {
    private val _events = MutableSharedFlow<DebugEvent>()
    val events = _events.asSharedFlow()

    fun initGameState() {
        viewModelScope.launch {
            restartAdventureGame()
        }
    }

    fun goBack() {
        viewModelScope.launch {
            _events.emit(DebugEvent.HOME)
            finishGameUseCase()
        }
    }
}

enum class DebugEvent {
    HOME
}
