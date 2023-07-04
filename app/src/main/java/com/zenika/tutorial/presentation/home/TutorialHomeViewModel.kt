package com.zenika.tutorial.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenika.adventure.domain.FinishGameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TutorialHomeViewModel @Inject constructor(
    private val finishGameUseCase: FinishGameUseCase
) : ViewModel() {
    private val _events = MutableSharedFlow<TutorialHomeEvent>()
    val events = _events.asSharedFlow()

    fun goBack() {
        viewModelScope.launch {
            _events.emit(TutorialHomeEvent.HOME)
            finishGameUseCase()
        }
    }
}

enum class TutorialHomeEvent {
    HOME
}