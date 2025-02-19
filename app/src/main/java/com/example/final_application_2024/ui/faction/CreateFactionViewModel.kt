package com.example.final_application_2024.ui.faction

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.final_application_2024.data.FactionRepository
import com.example.final_application_2024.data.Faction
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
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

    private val _uiState2 = MutableStateFlow<EditFactionUiState>(EditFactionUiState.Loading)
    val uiState2: StateFlow<EditFactionUiState>
        get() = _uiState2.asStateFlow()

    fun createFaction(name:String) {
        //val newFaction = Faction(0, name)
        viewModelScope.launch {
            _uiState.value = CreateFactionListUiState.Loading
            val result = repository.create(name)
            if (result.isSuccess) {
                _uiState.value = CreateFactionListUiState.Finished
            } else {
                result.exceptionOrNull()?.let {
                    _uiState.value = CreateFactionListUiState.Error(it.toString())
                }
            }/**/
        }
    }

    fun updateFaction(id:Int) {
        viewModelScope.launch {
            val faction = repository.readOne(id)
            _uiState.value = CreateFactionListUiState.Loading
            val result = repository.update(faction)
            if (result.isSuccess) {
                _uiState.value = CreateFactionListUiState.Finished
            } else {
                result.exceptionOrNull()?.let {
                    _uiState.value = CreateFactionListUiState.Error(it.toString())
                }
            }/**/
        }
    }

    fun getFaction(id:Int) {
        viewModelScope.launch {
            val faction = repository.readOne(id)
            _uiState2.collect {
                _uiState2.value = EditFactionUiState.InitialState(faction)
            }/**/
        }
    }
}

sealed class CreateFactionListUiState {
    data object InitialState : CreateFactionListUiState()
    data object Loading : CreateFactionListUiState()
    data class Error(val message:String) : CreateFactionListUiState()
    data object Finished : CreateFactionListUiState()
}

sealed class EditFactionUiState {
    data class InitialState(val faction:Faction) : EditFactionUiState()
    data object Loading : EditFactionUiState()
    data class Error(val message:String) : EditFactionUiState()
    data object Finished : EditFactionUiState()
}

data class CreateFactionUiState(
    val name:String
)