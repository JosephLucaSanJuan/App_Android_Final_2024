package com.example.final_application_2024.ui.create_transformer

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class CreateRobotViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow<CreateRobotListUiState>(CreateRobotListUiState.Loading)
    val uiState
        get() = _uiState.asStateFlow()
}

sealed class CreateRobotListUiState {
    data object InitialState : CreateRobotListUiState()
    data object Loading : CreateRobotListUiState()
    class Error(message:String) : CreateRobotListUiState()
    data object Finished : CreateRobotListUiState()
}

data class CreateRobotUiState(
    val name:String,
    val altMode:String,
    val gender:String
)