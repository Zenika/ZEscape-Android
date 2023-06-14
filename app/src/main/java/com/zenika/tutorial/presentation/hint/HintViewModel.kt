package com.zenika.tutorial.presentation.hint

import androidx.lifecycle.ViewModel
import com.zenika.tutorial.domain.GetCurrentHintUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HintViewModel @Inject constructor(
    getCurrentHintUseCase: GetCurrentHintUseCase
) : ViewModel() {
    val currentHint = getCurrentHintUseCase()
}