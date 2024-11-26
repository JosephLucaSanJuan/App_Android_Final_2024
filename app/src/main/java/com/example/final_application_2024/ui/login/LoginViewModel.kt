package com.example.final_application_2024.ui.login

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow<LoginListUiState>(LoginListUiState.LoggingIn)
    val uiState: StateFlow<LoginListUiState>
        get() = _uiState.asStateFlow()
}

sealed class LoginListUiState {
    data object InitialState : LoginListUiState()
    data object LoggingIn : LoginListUiState()
    class Error(message:String) : LoginListUiState()
    data object LoggedIn : LoginListUiState()
}

data class LoginUiState(
    val id:Int,
    val email:String,
    val password:String
)