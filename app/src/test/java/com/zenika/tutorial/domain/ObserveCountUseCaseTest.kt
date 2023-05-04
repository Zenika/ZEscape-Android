package com.zenika.tutorial.domain

import com.zenika.data.repository.CountRepository
import io.mockk.coEvery
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@OptIn(ExperimentalCoroutinesApi::class)
@ExtendWith(MockKExtension::class)
internal class ObserveCountUseCaseTest {

    @MockK(relaxed = true)
    lateinit var countRepository: CountRepository

    @InjectMockKs
    lateinit var observeCount: ObserveCountUseCase

    @Test
    @DisplayName("Should use default Zero for first count")
    fun shouldObserveFirstCount() = runTest {
        // Given
        coEvery { countRepository.observeCurrentCount() } returns flowOf(null)

        // When
        val countFlow = observeCount()

        // Then
        assertEquals(countFlow.first(), 0, "First count should be Zero")
    }

    @Test
    @DisplayName("Should observe new values")
    fun shouldObserveCount() = runTest {
        // Given
        coEvery { countRepository.observeCurrentCount() } returns flowOf(15)

        // When
        val countFlow = observeCount()

        // Then
        assertEquals(countFlow.first(), 15, "Count should be 15")
    }

}
