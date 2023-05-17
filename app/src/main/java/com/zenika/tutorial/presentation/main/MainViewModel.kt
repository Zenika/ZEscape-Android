package com.zenika.tutorial.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenika.data.repository.ItemRepository
import com.zenika.tutorial.SharedViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val itemRepository: ItemRepository,
    private val sharedViewModel: SharedViewModel
) : ViewModel() {

    fun updateMapState() {
        sharedViewModel.updateMapState()
    }

    fun addItem(itemName: String, itemRes: Int) {
        viewModelScope.launch {
            itemRepository.addItem(itemName, itemRes)
        }
    }
}
