package com.zenika.tutorial.presentation.score

import androidx.lifecycle.ViewModel
import com.zenika.tutorial.domain.ObserveStatisticsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ScoreViewModel @Inject constructor(
    observeStatisticsUseCase: ObserveStatisticsUseCase
) : ViewModel() {
    val statistics = observeStatisticsUseCase()
}

