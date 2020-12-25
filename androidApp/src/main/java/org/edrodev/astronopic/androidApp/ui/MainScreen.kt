package org.edrodev.astronopic.androidApp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
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
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.datetime.LocalDate
import org.edrodev.astronopic.core.Failure
import org.edrodev.astronopic.core.datetime.today
import org.edrodev.astronopic.domain.model.Apod
import org.edrodev.astronopic.presentation.core.Resource
import org.edrodev.astronopic.presentation.core.asSuccess
import org.edrodev.astronopic.presentation.core.fold

@Composable
fun MainScreen(
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit,
    dateFlow: StateFlow<LocalDate>,
    apodFlow: Flow<Resource<Failure, Apod>>
) {
    val resource = apodFlow.collectAsState(initial = Resource.Loading)
    val resourceDate = dateFlow.collectAsState()
    // A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {

        Column {
            TopAppBar(modifier = Modifier.fillMaxWidth()) {
                Text(modifier = Modifier.align(Alignment.CenterVertically)
                    .padding(16.dp),
                    text = resourceDate.value.toString())
            }

            Box(
                modifier = Modifier.fillMaxHeight()
            ) {
                resource.value.fold(
                    onFailure = {
                        when (it) {
                            is Failure.NotFound -> FailureNotFound()
                            is Failure.Unknown -> FailureUnknown()
                        }
                    },
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

                    if(resourceDate.value < today()) {
                        Button(onClick = onNextClick) {
                            Image(imageVector = Icons.Filled.ArrowForward)
                        }
                    }
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
            dateFlow = MutableStateFlow(today()),
            apodFlow = flowOf(Resource.Loading)
        )
    }
}

@Preview(name = "Success", showBackground = true)
@Composable
private fun SuccessPreview() {
    ApodTheme {
        MainScreen(
            onPreviousClick = { },
            onNextClick = { },
            dateFlow = MutableStateFlow(today()),
            apodFlow = flowOf(apodFake.asSuccess())
        )
    }
}