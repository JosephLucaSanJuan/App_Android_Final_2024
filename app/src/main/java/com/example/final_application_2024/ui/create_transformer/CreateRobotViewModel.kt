package com.example.final_application_2024.ui.create_transformer

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class CreateRobotViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow<CreateRobotUiState>(CreateRobotUiState("","",""))
    val uiState
        get() = _uiState.asStateFlow()
}

data class CreateRobotUiState(
    val name:String,
    val altMode:String,
    val gender:String
)