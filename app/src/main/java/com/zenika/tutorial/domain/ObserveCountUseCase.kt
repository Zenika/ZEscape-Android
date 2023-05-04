package com.zenika.tutorial.domain

import com.zenika.data.repository.CountRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ObserveCountUseCase @Inject constructor(
    private val repository: CountRepository
) {
    operator fun invoke(): Flow<Int> = repository.observeCurrentCount()
        .map { it ?: DEFAULT_COUNT }
}
