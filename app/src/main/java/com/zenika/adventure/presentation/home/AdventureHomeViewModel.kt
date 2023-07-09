package com.zenika.adventure.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenika.adventure.domain.FinishGameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AdventureHomeViewModel @Inject constructor(
    private val finishGameUseCase: FinishGameUseCase
) : ViewModel() {
    private val _events = MutableSharedFlow<AdventureHomeEvent>()
    val events = _events.asSharedFlow()

    fun goBack() {
        viewModelScope.launch {
            _events.emit(AdventureHomeEvent.HOME)
            finishGameUseCase()
        }
    }
}

enum class AdventureHomeEvent {
    HOME
}