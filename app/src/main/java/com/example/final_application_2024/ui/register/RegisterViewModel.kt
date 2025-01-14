package com.example.final_application_2024.ui.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.final_application_2024.data.UserRepository
import com.example.final_application_2024.ui.login.LoginListUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow<RegisterListUiState>(RegisterListUiState.Loading)
    val uiState: StateFlow<RegisterListUiState>
        get() = _uiState.asStateFlow()

    fun onRegister(username:String, email:String, password:String) {
        viewModelScope.launch {
            _uiState.value = RegisterListUiState.Loading

            val result = userRepository.register(username, email, password)
            if (result.isSuccess) {
                _uiState.value = RegisterListUiState.Registered
            } else {
                result.exceptionOrNull()?.let {
                    _uiState.value = RegisterListUiState.Error(it.toString())
                }
            }
        }
    }
}

sealed class RegisterListUiState {
    data object InitialState : RegisterListUiState()
    data object Loading : RegisterListUiState()
    data class Error(val message:String) : RegisterListUiState()
    data object Registered : RegisterListUiState()
}

data class RegisterUiState(
    val id:Int,
    val name:String,
    val surname:String,
    val email:String,
    val password:String
)