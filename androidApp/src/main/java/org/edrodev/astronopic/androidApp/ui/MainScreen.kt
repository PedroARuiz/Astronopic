package org.edrodev.astronopic.androidApp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import org.edrodev.astronopic.core.Failure
import org.edrodev.astronopic.domain.model.Apod
import org.edrodev.astronopic.presentation.core.Resource
import org.edrodev.astronopic.presentation.core.asSuccess
import org.edrodev.astronopic.presentation.core.fold

@Composable
fun MainScreen(onPreviousClick: () -> Unit, onNextClick: () -> Unit, apodFlow: Flow<Resource<Failure, Apod>>) {
    // A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Box {
            val resource = apodFlow.collectAsState(initial = Resource.Loading)
            resource.value.fold(
                onFailure = {},
                onLoading = { Loading() },
                onSuccess = { apod ->
                    Apod(apod)
                },
            )

            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(16.dp)
                    .align(Alignment.Center),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(onClick = onPreviousClick) {
                    Image(imageVector = Icons.Filled.ArrowBack)
                }
                Button(onClick = onNextClick) {
                    Image(imageVector = Icons.Filled.ArrowForward)
                }
            }
        }
    }
}

@Preview(name = "Loading", showBackground = true)
@Composable
private fun MainScreenLoadingPreview() {
    ApodTheme {
        MainScreen(
            onPreviousClick = { },
            onNextClick = { },
            apodFlow = flowOf(Resource.Loading)
        )
    }
}

@Preview(name = "Success", showBackground = true)
@Composable
fun SuccessPreview() {
    ApodTheme {
        MainScreen(
            onPreviousClick = { },
            onNextClick = { },
            apodFlow = flowOf(apodFake.asSuccess())
        )
    }
}