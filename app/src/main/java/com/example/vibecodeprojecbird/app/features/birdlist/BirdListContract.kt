package com.example.vibecodeprojecbird.app.features.birdlist

import com.example.vibecodeprojecbird.core.common.mvi.UiEffect
import com.example.vibecodeprojecbird.core.common.mvi.UiIntent
import com.example.vibecodeprojecbird.core.common.mvi.UiState

sealed interface BirdListIntent : UiIntent {
    data object LoadBirds : BirdListIntent
}

data class BirdListUiState(
    val isLoading: Boolean = false,
    val birds: List<Bird> = emptyList(),
    val error: String? = null
) : UiState

sealed interface BirdListEffect : UiEffect
