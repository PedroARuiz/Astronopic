package org.edrodev.astronopic.androidApp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
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
import kotlinx.datetime.LocalDate
import org.edrodev.astronopic.core.Failure
import org.edrodev.astronopic.core.datetime.today
import org.edrodev.astronopic.domain.model.Apod
import org.edrodev.astronopic.presentation.apod.ApodViewModel
import org.edrodev.astronopic.presentation.core.Resource
import org.edrodev.astronopic.presentation.core.fold
import org.koin.androidx.compose.getViewModel

@Composable
fun MainScreen(
    viewModel: ApodViewModel = getViewModel(),
) {
    val resource = viewModel.apod.collectAsState(initial = Resource.Loading)
    val resourceDate = viewModel.date.collectAsState()

    MainScreen(
        onPreviousClick = { viewModel.previous() },
        onNextClick = { viewModel.next() },
        resource = resource.value,
        date = resourceDate.value,
    )
}

@Composable
private fun MainScreen(
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit,
    resource: Resource<Failure, Apod>,
    date: LocalDate,
) {

    Column {
        TopAppBar(modifier = Modifier.fillMaxWidth()) {
            Text(modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(16.dp),
                text = date.toString())
        }

        Box(
            modifier = Modifier.fillMaxHeight()
        ) {
            resource.fold(
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
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .align(Alignment.Center),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(onClick = onPreviousClick) {
                    Image(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
                }

                if(date < today()) {
                    Button(onClick = onNextClick) {
                        Image(imageVector = Icons.Filled.ArrowForward, contentDescription = null)
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
            resource = Resource.Loading,
            date = today(),
        )
    }
}