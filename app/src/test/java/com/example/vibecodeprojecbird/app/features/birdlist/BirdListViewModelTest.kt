package com.example.vibecodeprojecbird.app.features.birdlist

import com.example.vibecodeprojecbird.core.testing.MainDispatcherRule
import com.example.vibecodeprojecbird.core.common.coroutines.AppDispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class BirdListViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @Test
    fun `loads birds on initialization`() = runTest {
        // Usamos o testScheduler do runTest para sincronizar os dispatchers
        val testDispatcher = StandardTestDispatcher(testScheduler)
        val appDispatchers = AppDispatchers(
            main = testDispatcher,
            io = testDispatcher,
            default = testDispatcher
        )

        val viewModel = BirdListViewModel(dispatchers = appDispatchers)

        // Inicialmente deve estar em loading por causa do init { LoadBirds }
        // Com StandardTestDispatcher, a corrotina lançada no init ainda não rodou nada (nem o isLoading = true)
        // a menos que chamemos algo para avançar.
        
        // Vamos avançar apenas o suficiente para pegar o isLoading = true
        testDispatcher.scheduler.runCurrent()
        assertEquals(true, viewModel.uiState.value.isLoading)

        // Agora avançamos tudo (incluindo o delay de 500ms)
        advanceUntilIdle()

        // Verificamos o estado final
        assertEquals(false, viewModel.uiState.value.isLoading)
        assertEquals(5, viewModel.uiState.value.birds.size)
        assertEquals("Pardal", viewModel.uiState.value.birds[0].name)
    }
}
