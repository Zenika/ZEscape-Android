package com.zenika.feature1.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenika.feature1.domain.IncrementCountUserCase
import com.zenika.feature1.domain.ObserveCountUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Feature1ViewModel @Inject constructor(
    observeCount: ObserveCountUseCase,
    private val incrementCount: IncrementCountUserCase
) : ViewModel() {

    val state: StateFlow<Feature1State> = observeCount()
        .map { count -> Feature1State(count) }
        .stateIn(
            scope = viewModelScope,
            initialValue = Feature1State.start(),
            started = SharingStarted.WhileSubscribed(5_000)
        )

    fun onTouch() {
        viewModelScope.launch {
            incrementCount()
        }
    }
}

data class Feature1State(
    val count: Int?
) {
    companion object {
        fun start(): Feature1State = Feature1State(
            count = null
        )
    }
}
