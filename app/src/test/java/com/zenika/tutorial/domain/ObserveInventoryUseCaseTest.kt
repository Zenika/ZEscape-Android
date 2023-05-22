package com.zenika.tutorial.domain

import com.zenika.data.model.ItemDto
import com.zenika.data.repository.ItemRepository
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
internal class ObserveInventoryUseCaseTest {

    @MockK(relaxed = true)
    lateinit var itemRepository: ItemRepository

    @InjectMockKs
    lateinit var observeInventory: ObserveInventoryUseCase

    @Test
    @DisplayName("Should get first item")
    fun shouldObserveFirstItemInventory() = runTest {
        // Given
        coEvery { itemRepository.observeItems() } returns flowOf(listOf(ItemDto("test", 0)))

        // When
        val inventoryFlow = observeInventory()

        // Then
        assertEquals(inventoryFlow.first().first(), ItemDto("test", 0), "Item should be test")
    }

    @Test
    @DisplayName("Should observe list of 10 items")
    fun shouldObserveInventory() = runTest {
        // Given
        coEvery { itemRepository.observeItems() } returns flowOf(listOf(ItemDto("test", 0)))

        // When
        val inventoryFlow = observeInventory()

        // Then
        assertEquals(
            inventoryFlow.first(), listOf(
                ItemDto("test", 0),
                ItemDto("", 0),
                ItemDto("", 0),
                ItemDto("", 0),
                ItemDto("", 0),
                ItemDto("", 0),
                ItemDto("", 0),
                ItemDto("", 0),
                ItemDto("", 0),
                ItemDto("", 0)
            ), "Inventory should have 10 items"
        )
    }

}
