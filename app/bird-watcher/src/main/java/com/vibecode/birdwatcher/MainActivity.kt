package com.vibecode.birdwatcher

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vibecode.birdwatcher.diary.DiaryScreen
import com.vibecode.birdwatcher.diary.DiaryViewModel
import com.vibecode.birdwatcher.ui.theme.BirdWatcherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BirdWatcherTheme {
                val viewModel: DiaryViewModel = viewModel()
                DiaryScreen(viewModel = viewModel)
            }
        }
    }
}
