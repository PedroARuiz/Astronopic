package org.edrodev.astronopic.androidApp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.setContent
import org.edrodev.astronopic.androidApp.ui.ApodTheme
import org.edrodev.astronopic.androidApp.ui.MainScreen
import org.edrodev.astronopic.presentation.apod.ApodViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: ApodViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ApodTheme {
                MainScreen(
                    onPreviousClick = { viewModel.previous() },
                    onNextClick = { viewModel.next() },
                    dateFlow = viewModel.date,
                    apodFlow = viewModel.apod,
                )
            }
        }
    }
}
