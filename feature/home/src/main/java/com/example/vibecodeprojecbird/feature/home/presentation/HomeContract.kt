package com.example.vibecodeprojecbird.feature.home.presentation

import com.example.vibecodeprojecbird.core.common.mvi.UiEffect
import com.example.vibecodeprojecbird.core.common.mvi.UiIntent
import com.example.vibecodeprojecbird.core.common.mvi.UiState

sealed interface HomeIntent : UiIntent {
    data object IncrementCounter : HomeIntent
}

data class HomeUiState(
    val title: String = "Project bootstrap ready",
    val message: String = "Compose + Material 3 + MVI baseline configured.",
    val counter: Int = 0
) : UiState

sealed interface HomeEffect : UiEffect
