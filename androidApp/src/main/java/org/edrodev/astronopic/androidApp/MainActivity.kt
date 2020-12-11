package org.edrodev.astronopic.androidApp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.flow.flowOf
import org.edrodev.astronopic.androidApp.ui.ApodTheme
import org.edrodev.astronopic.androidApp.ui.MainScreen
import org.edrodev.astronopic.presentation.apod.ApodViewModel
import org.edrodev.astronopic.presentation.core.Resource
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val viewModel: ApodViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ApodTheme {
                MainScreen(
                    onPreviousClick = { viewModel.previous() },
                    onNextClick = { viewModel.next() },
                    apodFlow = viewModel.apod
                )
            }
        }
    }
}
