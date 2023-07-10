package com.zenika.presentation.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenika.tutorial.domain.FinishGameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val finishGameUseCase: FinishGameUseCase
) : ViewModel() {
    private val _events = MutableSharedFlow<SettingsEvent>()
    val events = _events.asSharedFlow()

    fun goBackToHome() {
        viewModelScope.launch {
            _events.emit(SettingsEvent.HOME)
            finishGameUseCase()
        }
    }
}

enum class SettingsEvent {
    HOME
}