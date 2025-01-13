package com.example.final_application_2024.ui.camera

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class IncidentEditViewModel @Inject constructor() : ViewModel() {

    private val _photo = MutableStateFlow<Uri>(Uri.EMPTY)
    val photo: StateFlow<Uri>
        get() = _photo.asStateFlow()

    fun onImageCaptured(uri: Uri?) {
        viewModelScope.launch {
            uri?.let {
                photo.value
            }
        }
    }
}