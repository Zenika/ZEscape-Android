package com.zenika.story.tutorial.presentation.penalty

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class TutorialPenaltyViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private var penaltyName: String =
        savedStateHandle.get<String>("penalty") ?: error("Penalty is required")

    private var _penalty = MutableStateFlow(penaltyName)
    val penalty: StateFlow<String> = _penalty
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
            initialValue = penaltyName
        )
}
