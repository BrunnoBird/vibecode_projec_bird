package com.example.vibecodeprojecbird.feature.home.presentation

import androidx.lifecycle.ViewModelProvider
import com.example.vibecodeprojecbird.core.common.coroutines.AppDispatchers
import com.example.vibecodeprojecbird.core.common.mvi.MviViewModel

class HomeViewModel(
    private val dispatchers: AppDispatchers = AppDispatchers()
) : MviViewModel<HomeIntent, HomeUiState, HomeEffect>(HomeUiState()) {

    override fun onIntent(intent: HomeIntent) {
        when (intent) {
            HomeIntent.IncrementCounter -> updateState {
                copy(counter = counter + 1)
            }
        }
    }
}

class HomeViewModelFactory(
    private val dispatchers: AppDispatchers = AppDispatchers()
) : ViewModelProvider.Factory {
    override fun <T : androidx.lifecycle.ViewModel> create(modelClass: Class<T>): T {
        require(modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            "Unknown ViewModel class: ${modelClass.name}"
        }
        @Suppress("UNCHECKED_CAST")
        return HomeViewModel(dispatchers) as T
    }
}
