package com.zenika.story.adventure.presentation.score

import androidx.lifecycle.ViewModel
import com.zenika.story.adventure.domain.GetStatisticsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AdventureScoreViewModel @Inject constructor(
    getStatistics: GetStatisticsUseCase
) : ViewModel() {
    val statistics = getStatistics()
}
