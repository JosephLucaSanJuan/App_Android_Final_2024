package com.example.final_application_2024.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class NavigationEvent {
    data object ToHome: NavigationEvent()
    data object toFactions: NavigationEvent()
    data object toTransformers: NavigationEvent()
}

@HiltViewModel
class NavigationSharedViewModel @Inject constructor(): ViewModel() {
    private val _navigationEvents = MutableSharedFlow<NavigationEvent>(replay = 0)
    val navigationEvents: SharedFlow<NavigationEvent> get() = _navigationEvents

    fun onNavigateToHome() {
        _navigationEvents.tryEmit(NavigationEvent.ToHome)
    }

    fun onNavigateToTransformers() {
        viewModelScope.launch {
            _navigationEvents.tryEmit(NavigationEvent.toTransformers)
        }
    }

    fun onNavigateToFactions() {
        viewModelScope.launch {
            _navigationEvents.tryEmit(NavigationEvent.toFactions)
        }
    }
}