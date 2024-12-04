package com.example.final_application_2024.ui.register

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow<RegisterListUiState>(RegisterListUiState.Loading)
    val uiState: StateFlow<RegisterListUiState>
        get() = _uiState.asStateFlow()
}

sealed class RegisterListUiState {
    data object InitialState : RegisterListUiState()
    data object Loading : RegisterListUiState()
    class Error(message:String) : RegisterListUiState()
    data object Registered : RegisterListUiState()
}

data class RegisterUiState(
    val id:Int,
    val name:String,
    val surname:String,
    val email:String,
    val password:String
)