package com.zenika.adventure.presentation.montreal.simon_says

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenika.tutorial.domain.ObserveRemainingTimeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

private const val GAME_SIZE = 16
private const val SEQUENCE_SIZE = 7

@HiltViewModel
class SimonsSaysViewModel @Inject constructor(
    observeRemainingTime: ObserveRemainingTimeUseCase
) : ViewModel() {
    val remainingTime: StateFlow<Int> =
        observeRemainingTime()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
                initialValue = 3_600_600
            )

    private val _events = MutableSharedFlow<SimonsSaysGameEvent>()
    val events = _events.asSharedFlow()

    private val _state = MutableStateFlow(
        SimonState(
            mode = SimonGridMode.SYSTEM,
            lightButton = null,
            buttonsText = (1..GAME_SIZE).toList(),
            systemSequence = initSystemSequence(),
            playerSequence = mutableListOf()
        )
    )
    val state = _state.asStateFlow()

    private fun initSystemSequence(): List<Int> {
        val sequence = mutableListOf<Int>()
        for (i in 1..SEQUENCE_SIZE) {
            val random = Random.nextInt(GAME_SIZE) + 1
            sequence.add(random)
        }
        return sequence
    }

    fun startSimonsSays() {
        viewModelScope.launch {
            delay(1000)
            for (number in _state.value.systemSequence) {
                lightButton(number)
            }
            _state.update {
                it.copy(mode = SimonGridMode.PLAYER)
            }
        }
    }

    private suspend fun lightButton(number: Int) {
        _state.update {
            it.copy(lightButton = number)
        }
        delay(1500)
        _state.update {
            it.copy(lightButton = null)
        }
        delay(200)
    }

    fun onButtonClick(number: Int) {
        viewModelScope.launch {
            _state.update {
                it.playerSequence.add(number)
                it
            }
            checkSequence()
            checkWin()
        }
    }

    private fun checkSequence() {
        for (int in 0 until (_state.value.playerSequence.size)) {
            if (_state.value.playerSequence[int] == _state.value.systemSequence[int]) {
                continue
            } else {
                _state.update {
                    it.copy(
                        playerSequence = mutableListOf(),
                        mode = SimonGridMode.SYSTEM
                    )
                }
                startSimonsSays()
            }
        }
    }

    private suspend fun checkWin() {
        if (_state.value.playerSequence.size == _state.value.systemSequence.size) {
            _events.emit(SimonsSaysGameEvent.WIN)
        }
    }
}

data class SimonState(
    val mode: SimonGridMode,
    val lightButton: Int?,
    val buttonsText: List<Int>,
    val systemSequence: List<Int>,
    var playerSequence: MutableList<Int>
)

enum class SimonsSaysGameEvent {
    WIN
}
