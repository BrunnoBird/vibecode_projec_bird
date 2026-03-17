package com.example.vibecodeprojecbird.app.di

import com.example.vibecodeprojecbird.app.features.birdlist.BirdListViewModelFactory
import com.example.vibecodeprojecbird.feature.home.presentation.HomeViewModelFactory

class AppContainer {
    val homeViewModelFactory: HomeViewModelFactory = HomeViewModelFactory()
    val birdListViewModelFactory: BirdListViewModelFactory = BirdListViewModelFactory()
}
