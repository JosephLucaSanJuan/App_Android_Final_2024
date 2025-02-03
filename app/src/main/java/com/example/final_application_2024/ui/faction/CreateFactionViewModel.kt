package com.example.final_application_2024.ui.faction

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.final_application_2024.data.FactionRepository
import com.example.final_application_2024.data.Faction
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class CreateFactionViewModel @Inject constructor(
    private val repository: FactionRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow<CreateFactionListUiState>(CreateFactionListUiState.Loading)
    val uiState: StateFlow<CreateFactionListUiState>
        get() = _uiState.asStateFlow()

    fun createFaction(name:String) {
        val newFaction = Faction(0, name)
        viewModelScope.launch {
            _uiState.value = CreateFactionListUiState.Loading
            val result = repository.create(newFaction)
            /*if (result.isSuccess) {
                _uiState.value = CreateFactionListUiState.Registered
            } else {
                result.exceptionOrNull()?.let {
                    _uiState.value = CreateFactionListUiState.Error(it.toString())
                }
            }*/
        }
    }
}

sealed class CreateFactionListUiState {
    data object InitialState : CreateFactionListUiState()
    data object Loading : CreateFactionListUiState()
    data class Error(val message:String) : CreateFactionListUiState()
    data object Registered : CreateFactionListUiState()
}

data class CreateFactionUiState(
    val name:String
)