package com.example.vibecodeprojecbird.app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.vibecodeprojecbird.app.di.AppContainer
import com.example.vibecodeprojecbird.app.navigation.AppNavHost
import com.example.vibecodeprojecbird.core.designsystem.theme.ProjectTheme
import com.example.vibecodeprojecbird.feature.home.presentation.HomeViewModel

@Composable
fun AppRoot() {
    val appContainer = remember { AppContainer() }

    ProjectTheme {
        AppNavHost(
            homeViewModelFactory = {
                viewModel<HomeViewModel>(
                    factory = appContainer.homeViewModelFactory
                )
            },
            birdListViewModelFactory = {
                viewModel(
                    factory = appContainer.birdListViewModelFactory
                )
            }
        )
    }
}
