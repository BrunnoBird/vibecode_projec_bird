package com.example.vibecodeprojecbird.app.features.birdlist

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.vibecodeprojecbird.core.common.coroutines.AppDispatchers
import com.example.vibecodeprojecbird.core.common.mvi.MviViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class BirdListViewModel(
    private val dispatchers: AppDispatchers = AppDispatchers()
) : MviViewModel<BirdListIntent, BirdListUiState, BirdListEffect>(BirdListUiState()) {

    init {
        onIntent(BirdListIntent.LoadBirds)
    }

    override fun onIntent(intent: BirdListIntent) {
        when (intent) {
            is BirdListIntent.LoadBirds -> loadBirdsMock()
        }
    }

    private fun loadBirdsMock() {
        updateState { copy(isLoading = true, error = null) }
        
        viewModelScope.launch(dispatchers.io) {
            // Simulação local de rede com um pequeno delay para engajar estado de loading
            delay(500)
            
            val mockBirds = listOf(
                Bird("1", "Pardal", "Um pássaro pequeno e muito comum nas cidades.", "https://dummyimage.com/400x400/ccc/000.png&text=Pardal"),
                Bird("2", "Bem-te-vi", "Famoso pelo seu canto característico.", "https://dummyimage.com/400x400/ccc/000.png&text=Bem-te-vi"),
                Bird("3", "Tucano", "Conhecido pelo seu bico grande e colorido.", "https://dummyimage.com/400x400/ccc/000.png&text=Tucano"),
                Bird("4", "Arara Azul", "Espécie nativa do Brasil, com plumagem vibrante.", "https://dummyimage.com/400x400/ccc/000.png&text=Arara+Azul"),
                Bird("5", "Beija-flor", "Pássaro veloz e de asas muito ágeis.", "https://dummyimage.com/400x400/ccc/000.png&text=Beija-flor")
            )
            
            updateState { 
                copy(
                    isLoading = false,
                    birds = mockBirds
                )
            }
        }
    }
}

class BirdListViewModelFactory(
    private val dispatchers: AppDispatchers = AppDispatchers()
) : ViewModelProvider.Factory {
    override fun <T : androidx.lifecycle.ViewModel> create(modelClass: Class<T>): T {
        require(modelClass.isAssignableFrom(BirdListViewModel::class.java)) {
            "Unknown ViewModel class: ${modelClass.name}"
        }
        @Suppress("UNCHECKED_CAST")
        return BirdListViewModel(dispatchers) as T
    }
}
