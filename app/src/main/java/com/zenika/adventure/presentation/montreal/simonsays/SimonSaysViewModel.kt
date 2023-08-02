package com.zenika.adventure.presentation.montreal.simonsays

import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenika.R
import com.zenika.adventure.domain.ObserveRemainingTimeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
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
private const val SHORT_DELAY: Long = 200
private const val MEDIUM_DELAY: Long = 500
private const val LONG_DELAY: Long = 1000

@HiltViewModel
class SimonsSaysViewModel @Inject constructor(
    observeRemainingTime: ObserveRemainingTimeUseCase
) : ViewModel() {
    val remainingTime: StateFlow<Int> =
        observeRemainingTime()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
                initialValue = 0
            )

    private val _events = MutableSharedFlow<SimonsSaysGameEvent>()
    val events = _events.asSharedFlow()

    private val _state = MutableStateFlow(
        SimonState(
            mode = SimonGridMode.SYSTEM,
            lightButton = null,
            buttonsText = ('A'..'P').toImmutableList(),
            systemSequence = mutableListOf(),
            playerSequence = mutableListOf(),
            indicationText = R.string.ready
        )
    )
    val state = _state.asStateFlow()

    fun startGame() {
        initGame(R.string.systemGame)
        playSystemSequence()
    }

    private fun initGame(indicationText: Int) {
        _state.update {
            it.copy(
                systemSequence = mutableListOf(),
                playerSequence = mutableListOf(),
                mode = SimonGridMode.SYSTEM,
                indicationText = indicationText
            )
        }
    }

    private suspend fun continueGame() {
        delay(MEDIUM_DELAY)
        _state.update {
            it.copy(
                playerSequence = mutableListOf(),
                mode = SimonGridMode.SYSTEM,
                indicationText = R.string.systemGame
            )
        }
        playSystemSequence()
    }

    private fun playSystemSequence() {
        viewModelScope.launch {
            addCharToSystemSequence()
            delay(MEDIUM_DELAY)
            for (char in _state.value.systemSequence) {
                lightButton(char)
            }
            _state.update {
                it.copy(
                    mode = SimonGridMode.PLAYER,
                    indicationText = R.string.playerGame
                )
            }
        }
    }

    private fun addCharToSystemSequence() {
        val random = Random.nextInt(GAME_SIZE)
        val randomChar = _state.value.buttonsText[random]
        _state.update {
            it.systemSequence.add(randomChar)
            it
        }
    }

    private suspend fun lightButton(char: Char) {
        _state.update {
            it.copy(lightButton = char)
        }
        delay(LONG_DELAY)
        _state.update {
            it.copy(lightButton = null)
        }
        delay(SHORT_DELAY)
    }

    fun onButtonClick(char: Char) {
        viewModelScope.launch {
            _state.update {
                it.playerSequence.add(char)
                it
            }
            checkSequence()
        }
    }

    private suspend fun checkSequence() {
        if (_state.value.playerSequence.size == _state.value.systemSequence.size) {
            if (_state.value.playerSequence.last() == _state.value.systemSequence.last()) {
                checkWin()
            } else {
                initGame(R.string.loseGame)
            }
        } else {
            val lastButtonClick = _state.value.playerSequence.last()
            val goodButton = _state.value.systemSequence[_state.value.playerSequence.size - 1]
            if (lastButtonClick != goodButton) {
                initGame(R.string.loseGame)
            }
        }
    }

    private suspend fun checkWin() {
        viewModelScope.launch {
            if (_state.value.playerSequence.size == SEQUENCE_SIZE) {
                _events.emit(SimonsSaysGameEvent.WIN)
            } else continueGame()
        }
    }
}

data class SimonState(
    val mode: SimonGridMode,
    val lightButton: Char?,
    val buttonsText: ImmutableList<Char>,
    var systemSequence: MutableList<Char>,
    var playerSequence: MutableList<Char>,
    @StringRes val indicationText: Int
)

enum class SimonsSaysGameEvent {
    WIN
}
