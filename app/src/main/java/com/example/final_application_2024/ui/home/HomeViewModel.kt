package com.example.final_application_2024.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.final_application_2024.data.FactionRepository
import com.example.final_application_2024.data.TransformersRepository
import com.example.final_application_2024.data.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val userRepository: UserRepository,
    val factionRepository: FactionRepository,
    val transformerRepository: TransformersRepository
): ViewModel() {
    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val uiState: StateFlow<HomeUiState>
        get() = _uiState.asStateFlow()

    fun onLogOut() {
        viewModelScope.launch {
            userRepository.logout()
            _uiState.value = HomeUiState.LoggedOut
        }
    }
}

sealed class HomeUiState {
    data object Loading: HomeUiState()
    data object LoggedOut: HomeUiState()
    data class LoggedIn(val factions:Int, val transformers:Int)/**/: HomeUiState()
    data class Error(val message:String): HomeUiState()
}