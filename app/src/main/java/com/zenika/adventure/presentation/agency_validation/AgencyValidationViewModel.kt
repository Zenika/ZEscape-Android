package com.zenika.adventure.presentation.agency_validation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenika.adventure.domain.AddAgencyUseCase
import com.zenika.data.Agency
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AgencyValidationViewModel @Inject constructor(
    private val addAgency: AddAgencyUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private var _agencyName: String =
        savedStateHandle.get<String>("agency") ?: error("Agency is required")

    private var _agency = MutableStateFlow(_agencyName)
    val agency: StateFlow<String> = _agency
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
            initialValue = _agencyName
        )

    private val _events = MutableSharedFlow<AgencyValidationEvent>()
    val events = _events.asSharedFlow()

    fun dismissAgency() {
        viewModelScope.launch {
            _events.emit(AgencyValidationEvent.DISMISS)
            _events.emit(AgencyValidationEvent.MAP)
        }
    }

    fun confirmAgency() {
        viewModelScope.launch {
            addAgency()
            _events.emit(AgencyValidationEvent.DISMISS)
            _events.emit(AgencyValidationEvent.MAP)
        }
    }

    private fun addAgency() {
        val agencyExists = Agency.values().any { it.name == agency.value }
        if (agencyExists) {
            addAgency(Agency.valueOf(agency.value))
        }
    }
}

enum class AgencyValidationEvent {
    DISMISS,
    MAP
}
