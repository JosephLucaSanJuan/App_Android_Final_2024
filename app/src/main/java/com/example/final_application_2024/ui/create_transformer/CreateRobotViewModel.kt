package com.example.final_application_2024.ui.create_transformer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.final_application_2024.data.Transformer
import com.example.final_application_2024.data.TransformersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class CreateRobotViewModel @Inject constructor(
    private val repository: TransformersRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow<CreateRobotListUiState>(CreateRobotListUiState.Loading)
    val uiState
        get() = _uiState.asStateFlow()

    private val _uiState2 = MutableStateFlow<EditTransformerUiState>(EditTransformerUiState.Loading)
    val uiState2
        get() = _uiState2.asStateFlow()

    fun createRobot(name:String, altMode:String, gender:String) {
        //val newTF = Transformer(0, name, altMode, gender)
        viewModelScope.launch {
            _uiState.value = CreateRobotListUiState.Loading
            val result = repository.create(name, altMode, gender)
            if (result.isSuccess) {
                _uiState.value = CreateRobotListUiState.Finished
            } else {
                result.exceptionOrNull()?.let {
                    _uiState.value = CreateRobotListUiState.Error(it.toString())
                }
            }
        }
    }

    fun updateRobot(id:Int, transformer:Transformer) {
        viewModelScope.launch {
            _uiState2.value = EditTransformerUiState.Loading
            val result = transformer.let{ repository.update(id, it) }
            if (result.isSuccess) {
                _uiState2.value = EditTransformerUiState.Finished
            } else {
                result.exceptionOrNull()?.let {
                    _uiState2.value = EditTransformerUiState.Error(it.toString())
                }
            }
        }
    }

}

sealed class CreateRobotListUiState {
    data object InitialState : CreateRobotListUiState()
    data object Loading : CreateRobotListUiState()
    data class Error(val message:String) : CreateRobotListUiState()
    data object Finished : CreateRobotListUiState()
}

sealed class EditTransformerUiState {
    data object InitialState : EditTransformerUiState()
    data object Loading : EditTransformerUiState()
    data class Error(val message:String) : EditTransformerUiState()
    data object Finished : EditTransformerUiState()
}

data class CreateRobotUiState(
    val name:String,
    val altMode:String,
    val gender:String
)