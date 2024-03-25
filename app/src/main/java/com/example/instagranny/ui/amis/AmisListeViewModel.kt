package com.example.instagranny.ui.amis

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import com.example.instagranny.data.AmisListeState
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AmisListeViewModel : ViewModel()  {
    private val _uiState = MutableStateFlow(AmisListeState())
    val uiState: StateFlow<AmisListeState> = _uiState.asStateFlow()


    fun enleverAmis(amisId :Int) {
        _uiState.update { currentState ->
            val updatedList = currentState.listeAmis.filter { it != amisId }
            currentState.copy(listeAmis = updatedList)
        }
    }

    fun resetListeAmis() {
        _uiState.value = AmisListeState()
    }
}