package com.zenika.adventure.presentation.home

import androidx.lifecycle.ViewModel
import com.zenika.tutorial.domain.FinishGameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val finishGameUseCase: FinishGameUseCase
) : ViewModel() {

    fun finishGame() {
        finishGameUseCase()
    }
}