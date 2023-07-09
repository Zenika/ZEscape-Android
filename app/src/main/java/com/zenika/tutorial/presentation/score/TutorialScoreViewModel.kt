package com.zenika.tutorial.presentation.score

import androidx.lifecycle.ViewModel
import com.zenika.tutorial.domain.GetStatisticsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TutorialScoreViewModel @Inject constructor(
    getStatistics: GetStatisticsUseCase
) : ViewModel() {
    val statistics = getStatistics()
}

