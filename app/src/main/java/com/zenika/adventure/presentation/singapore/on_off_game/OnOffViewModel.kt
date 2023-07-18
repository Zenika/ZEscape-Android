package com.zenika.adventure.presentation.singapore.on_off_game

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenika.tutorial.domain.ObserveRemainingTimeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

private const val GAME_SIZE = 20

@HiltViewModel
class OnOffViewModel @Inject constructor(
    observeRemainingTime: ObserveRemainingTimeUseCase
) : ViewModel() {
    val remainingTime: StateFlow<Int> =
        observeRemainingTime()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
                initialValue = 3_600_600
            )

    private val _events = MutableSharedFlow<OnOffGameEvent>()
    val events = _events.asSharedFlow()

    private val _state: MutableStateFlow<OnOffUiState> = MutableStateFlow(OnOffUiState(GAME_SIZE))
    val state: StateFlow<OnOffUiState> = _state

    private val shuffleCombinationButtons = mutableSetOf<Int>()

    private val buttons = (0 until GAME_SIZE).toList()

    private val combinations = mutableListOf<Pair<Int, Int>>()

    init {
        initCombinationButtons()
    }

    private fun initCombinationButtons() {
        while (shuffleCombinationButtons.size < GAME_SIZE / 2) {
            val size = shuffleCombinationButtons.size
            var random = Random.nextInt(0, GAME_SIZE)
            while (size == random || size + 10 == random) {
                random = Random.nextInt(0, GAME_SIZE)
            }
            shuffleCombinationButtons.add(random)
        }
        val shuffleCombinationList = shuffleCombinationButtons.toMutableList()
        shuffleCombinationList.addAll(shuffleCombinationList)

        for (i in 0 until GAME_SIZE) {
            combinations.add(buttons[i] to shuffleCombinationList[i])
        }
    }

    fun switchColor(buttonId: Int) {
        val combinedButtonToSwitch = getCombinedButtonToSwitch(buttonId)
        _state.update { it.withSwitchedButtons(buttonId, combinedButtonToSwitch) }
        viewModelScope.launch { checkWin() }
    }

    private fun getCombinedButtonToSwitch(buttonId: Int): Int =
        combinations.first { it.first == buttonId }.second

    private suspend fun checkWin() {
        if (_state.value.buttonsList.all { it }) {
            _events.emit(OnOffGameEvent.WIN)
        }
    }
}

class OnOffUiState(
    val buttonsList: List<Boolean> = listOf()
) {
    constructor(size: Int) : this((1..size).map { false })

    fun withSwitchedButtons(buttonId: Int, combinedButtonToSwitch: Int) = OnOffUiState(
        buttonsList.mapIndexed { index, value ->
            if (index == buttonId || index == combinedButtonToSwitch) !value else value
        }
    )
}

enum class OnOffGameEvent {
    WIN
}
