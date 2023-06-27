package com.zenika.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenika.adventure.domain.StartAdventureGameUseCase
import com.zenika.tutorial.domain.StartTutorialGameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val startTutorialGame: StartTutorialGameUseCase,
    private val startAdventureGame: StartAdventureGameUseCase
) : ViewModel() {

    fun initInventoryTutorial() {
        viewModelScope.launch {
            startTutorialGame()
        }
    }

    fun initInventoryAdventure() {
        viewModelScope.launch {
            startAdventureGame()
        }
    }
}