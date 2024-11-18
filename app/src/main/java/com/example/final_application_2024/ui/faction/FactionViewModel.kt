package com.example.final_application_2024.ui.faction

import androidx.lifecycle.ViewModel
import com.example.final_application_2024.data.FactionRepository
import com.example.final_application_2024.data.Faction
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FactionViewModel @Inject constructor(
    private val repository: FactionRepository
) : ViewModel() {
    suspend fun read():List<Faction>{
        return repository.readAll()
    }
}