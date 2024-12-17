package com.example.final_application_2024.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.final_application_2024.data.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow<LoginListUiState>(LoginListUiState.LoggingIn)
    val uiState: StateFlow<LoginListUiState>
        get() = _uiState.asStateFlow()

    fun onLogin(email: String, password: String) {
        viewModelScope.launch {
            _uiState.value = LoginListUiState.LoggingIn

            val result = repository.login(email, password)
            if (result.isSuccess) {
                _uiState.value = LoginListUiState.LoggedIn
            } else {
                result.exceptionOrNull()?.let {
                    _uiState.value = LoginListUiState.Error(it.toString())
                }
            }
        }
    }
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