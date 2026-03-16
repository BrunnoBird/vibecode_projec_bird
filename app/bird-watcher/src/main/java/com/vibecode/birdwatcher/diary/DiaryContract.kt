package com.vibecode.birdwatcher.diary

class DiaryContract {
    data class State(
        val isLoading: Boolean = false,
        val isEmpty: Boolean = true
    )

    sealed class Intent {
        // Inicialmente vazio para UI estática.
    }
}
