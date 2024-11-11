package com.example.final_application_2024.ui.transformer

import androidx.lifecycle.ViewModel
import com.example.final_application_2024.data.Transformer
import com.example.final_application_2024.data.TransformersRepository
import javax.inject.Inject

class TransformerViewModel @Inject constructor(
    private val repository: TransformersRepository
):ViewModel() {
    suspend fun read():List<Transformer>{
        return repository.readAll()
    }
}