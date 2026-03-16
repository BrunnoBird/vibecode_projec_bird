package com.vibecode.birdwatcher.diary

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class DiaryViewModel : ViewModel() {
    private val _state = MutableStateFlow(DiaryContract.State())
    val state: StateFlow<DiaryContract.State> = _state.asStateFlow()

    fun handleIntent(intent: DiaryContract.Intent) {
        // Ainda nao existe interacao estatica.
    }
}
