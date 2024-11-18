package com.example.final_application_2024.ui.transformer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.final_application_2024.data.Transformer
import com.example.final_application_2024.data.TransformersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TransformerViewModel @Inject constructor(
    private val repository: TransformersRepository
):ViewModel() {
    suspend fun read():List<Transformer>{
        return repository.readAll()
    }

    private val _uiState = MutableStateFlow<TransformersListUiState>(TransformersListUiState.Loading)
    val uiState: StateFlow<TransformersListUiState>
        get() = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            repository.observeAll().collect { transformers ->
                _uiState.value = TransformersListUiState.Success(transformers)
            }
        }
    }
}

sealed class TransformersListUiState {
    data object Loading: TransformersListUiState()
    class Error(message:String):TransformersListUiState()
    class Success(val transformers: List<Transformer>): TransformersListUiState()
}

data class TransformersUiState(
    val id:Int = 0,
    val nombre:String = ""
)