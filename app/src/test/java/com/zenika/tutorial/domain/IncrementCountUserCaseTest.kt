package com.zenika.tutorial.domain

import com.zenika.data.repository.CountRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@OptIn(ExperimentalCoroutinesApi::class)
@ExtendWith(MockKExtension::class)
internal class IncrementCountUserCaseTest {

    @MockK(relaxed = true)
    lateinit var countRepository: CountRepository

    @InjectMockKs
    lateinit var incrementCount: IncrementCountUserCase

    @Test
    @DisplayName("Should set 1 for the first increment")
    fun shouldSetFirstIncrement() = runTest {
        // Given
        coEvery { countRepository.observeCurrentCount() } returns flowOf(null)

        // When
        incrementCount()

        // Then
        coVerify(exactly = 1) { countRepository.setCount(1) }
    }

    @Test
    @DisplayName("Should increment from 12 to 13")
    fun shouldIncrementTo13() = runTest {
        // Given
        coEvery { countRepository.observeCurrentCount() } returns flowOf(12)

        // When
        incrementCount()

        // Then
        coVerify(exactly = 1) { countRepository.setCount(13) }
    }
}
