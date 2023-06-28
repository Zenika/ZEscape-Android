package com.zenika.adventure.presentation.singapore.on_off_game

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenika.adventure.domain.OpenSingaporeAgencyUseCase
import com.zenika.tutorial.domain.ObserveRemainingTimeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnOffViewModel @Inject constructor(
    observeRemainingTime: ObserveRemainingTimeUseCase,
    private val openSingaporeAgency: OpenSingaporeAgencyUseCase
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

    private val gameSize = 20

    private val _buttonsList = mutableStateListOf<Boolean>()
    val buttonsList get() = _buttonsList

    private val shuffleCombinationButtons = mutableSetOf<Int>()

    private val buttons = (0 until gameSize).toList()

    private val combinations = mutableListOf<Map<Int, Int>>()

    init {
        for (i in 1..gameSize) {
            buttonsList.add(false)
        }
        initCombinationButtons()
    }

    private fun initCombinationButtons() {
        while (shuffleCombinationButtons.size < gameSize / 2) {
            val size = shuffleCombinationButtons.size
            var random = (0 until gameSize).random()
            while (size == random || size + 10 == random) {
                random = (0 until gameSize).random()
            }
            shuffleCombinationButtons.add(random)
        }
        val shuffleCombinationList = shuffleCombinationButtons.toMutableList()
        shuffleCombinationList.addAll(shuffleCombinationList)

        for (i in 0 until gameSize) {
            combinations.add(mapOf(buttons[i] to shuffleCombinationList[i]))
        }
    }

    fun switchColor(buttonId: Int) {
        _buttonsList[buttonId] = _buttonsList[buttonId].not()
        buttonsList
        switchCombinationColor(buttonId)
    }

    private fun switchCombinationColor(buttonId: Int) {
        var button = 0
        for (combination in combinations) {
            if (combination.containsKey(buttonId)) {
                button = combination.getValue(buttonId)
            }
        }
        _buttonsList[button] = _buttonsList[button].not()
        viewModelScope.launch {
            checkWin()
        }
    }

    private suspend fun checkWin() {
        if (buttonsList.all { it }) {
            _events.emit(OnOffGameEvent.WIN)
            openSingaporeAgency()
        }
    }
}

enum class OnOffGameEvent {
    WIN
}
