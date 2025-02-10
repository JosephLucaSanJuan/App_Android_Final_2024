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
import javax.inject.Inject

@HiltViewModel
class FactionViewModel @Inject constructor(
    private val repository: FactionRepository
) : ViewModel() {
    suspend fun read():List<Faction>{
        return repository.readAll()
    }

    private val _uiState = MutableStateFlow<FactionListUiState>(FactionListUiState.Loading)
    val uiState:StateFlow<FactionListUiState>
        get() = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            repository.observeAll().collect { faction ->
                _uiState.value = FactionListUiState.Success(faction.getOrNull()!!)
            }
        }
    }
}

sealed class FactionListUiState {
    data object Loading: FactionListUiState()
    data class Error(val message:String):FactionListUiState()
    data class Success(val faction: List<Faction>): FactionListUiState()
}

data class FactionUiState(
    val id:Int = 0,
    val nombre:String = "",
    val altMode:String = ""
)