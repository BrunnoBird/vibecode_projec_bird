package com.example.vibecodeprojecbird.app.di

import com.example.vibecodeprojecbird.feature.home.presentation.HomeViewModelFactory

class AppContainer {
    val homeViewModelFactory: HomeViewModelFactory = HomeViewModelFactory()
}
