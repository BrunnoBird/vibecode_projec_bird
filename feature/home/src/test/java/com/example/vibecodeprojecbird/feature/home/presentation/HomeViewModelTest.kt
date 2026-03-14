package com.example.vibecodeprojecbird.feature.home.presentation

import com.example.vibecodeprojecbird.core.testing.MainDispatcherRule
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class HomeViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @Test
    fun `starts with baseline bootstrap state`() {
        val viewModel = HomeViewModel()

        assertEquals("Project bootstrap ready", viewModel.uiState.value.title)
        assertEquals(
            "Compose + Material 3 + MVI baseline configured.",
            viewModel.uiState.value.message
        )
        assertEquals(0, viewModel.uiState.value.counter)
    }

    @Test
    fun `increments counter when intent is received`() {
        val viewModel = HomeViewModel()

        viewModel.onIntent(HomeIntent.IncrementCounter)

        assertEquals(1, viewModel.uiState.value.counter)
    }
}
