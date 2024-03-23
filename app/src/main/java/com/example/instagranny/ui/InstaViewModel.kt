package com.example.instagranny.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class InstaViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(InstaUiState())
    val uiState: StateFlow<InstaUiState> = _uiState.asStateFlow()

    fun newAvatar(adresse: Int) {
        _uiState.update { currentState ->
            currentState.copy(
                adresseAvatar = adresse
            )
        }
    }

    fun newProfilName(name: String) {
        _uiState.update { currentState ->
            currentState.copy(
                profilNom = name
            )
        }
    }
}