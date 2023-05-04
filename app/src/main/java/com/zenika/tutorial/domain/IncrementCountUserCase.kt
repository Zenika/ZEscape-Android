package com.zenika.tutorial.domain

import com.zenika.data.repository.CountRepository
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class IncrementCountUserCase @Inject constructor(
    private val countRepository: CountRepository
) {
    suspend operator fun invoke() {
        val currentCount = countRepository.observeCurrentCount().first() ?: DEFAULT_COUNT
        countRepository.setCount(currentCount + 1)
    }
}
