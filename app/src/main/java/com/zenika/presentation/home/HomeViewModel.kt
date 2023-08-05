package com.zenika.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenika.adventure.domain.StartAdventureGameUseCase
import com.zenika.tutorial.domain.StartTutorialGameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val startTutorialGame: StartTutorialGameUseCase,
    private val startAdventureGame: StartAdventureGameUseCase
) : ViewModel() {
    private val _events = MutableSharedFlow<HomeEvent>()
    val events = _events.asSharedFlow()

    fun goToTutorial() {
        viewModelScope.launch {
            _events.emit(HomeEvent.TUTORIAL)
            startTutorialGame()
        }
    }

    fun goToAdventure() {
        viewModelScope.launch {
            _events.emit(HomeEvent.ADVENTURE)
            startAdventureGame()
        }
    }

    fun goToDebug() {
        viewModelScope.launch {
            _events.emit(HomeEvent.DEBUG)
            startAdventureGame()
        }
    }
}

enum class HomeEvent {
    TUTORIAL,
    ADVENTURE,
    DEBUG
}
