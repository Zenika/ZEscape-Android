package com.zenika.story.tutorial.presentation.hint

import androidx.lifecycle.ViewModel
import com.zenika.story.tutorial.domain.GetCurrentHintUseCase
import com.zenika.story.tutorial.domain.model.TutorialHint
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TutorialHintViewModel @Inject constructor(
    getCurrentHintUseCase: GetCurrentHintUseCase
) : ViewModel() {
    val currentHint: TutorialHint = getCurrentHintUseCase()
}
