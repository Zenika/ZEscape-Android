package com.zenika.tutorial.presentation.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenika.R
import com.zenika.data.repository.ItemRepository
import com.zenika.data.state.GameState
import com.zenika.tutorial.domain.InitInventoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val itemRepository: ItemRepository,
    private val initInventoryUseCase: InitInventoryUseCase,
    private val gameState: GameState
) : ViewModel() {
    fun updateMapState() {
        addItem("map", R.mipmap.rolled_map)
        gameState.collectMap()
    }

    init {
        Log.d("init inventory", "ok")
        viewModelScope.launch {
            initInventoryUseCase()
        }
    }

    private fun addItem(itemName: String, itemRes: Int) {
        viewModelScope.launch {
            itemRepository.addItem(itemName, itemRes)
        }
    }
}
