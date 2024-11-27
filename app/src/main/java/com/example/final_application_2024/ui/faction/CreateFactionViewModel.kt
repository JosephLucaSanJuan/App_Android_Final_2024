package com.example.final_application_2024.ui.faction

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class CreateFactionViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow<CreateFactionListUiState>(CreateFactionListUiState.Loading)
    val uiState: StateFlow<CreateFactionListUiState>
        get() = _uiState.asStateFlow()
}

sealed class CreateFactionListUiState {
    data object InitialState : CreateFactionListUiState()
    data object Loading : CreateFactionListUiState()
    class Error(message:String) : CreateFactionListUiState()
    data object Registered : CreateFactionListUiState()
}

data class CreateFactionUiState(
    val name:String
)