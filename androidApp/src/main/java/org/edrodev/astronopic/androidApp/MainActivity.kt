package org.edrodev.astronopic.androidApp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.request.ImageRequest
import dev.chrisbanes.accompanist.coil.CoilImage
import org.edrodev.astronopic.androidApp.ui.ApodTheme
import org.edrodev.astronopic.presentation.apod.ApodViewModel
import org.edrodev.astronopic.presentation.core.Resource
import org.edrodev.astronopic.presentation.core.fold
import org.edrodev.astronopic.presentation.core.successOrNull
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val viewModel: ApodViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ApodTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val resource = viewModel.apod.collectAsState(initial = Resource.Loading)
                    ScrollableColumn(modifier = Modifier
                        .fillMaxWidth()
                        .animateContentSize()
                    ) {
                        resource.value.fold(
                            onFailure = {},
                            onLoading = { Loading() },
                            onSuccess = { apod ->
                                CoilImage(
                                    modifier = Modifier.fillMaxWidth()
                                        .animateContentSize(),
                                    data = apod.url,
                                    contentScale = ContentScale.FillWidth,
                                    loading = { Icons.Filled.Star }
                                )
                                Text(
                                    modifier = Modifier.padding(16.dp)
                                        .animateContentSize(),
                                    text = apod.explanation
                                )
                            },
                        )

                        Row(
                            modifier = Modifier.fillMaxWidth()
                                .padding(16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Button(onClick = { viewModel.previous() }) {
                                Image(imageVector = Icons.Filled.ArrowBack)
                            }
                            Button(onClick = { viewModel.next() }) {
                                Image(imageVector = Icons.Filled.ArrowForward)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Loading() {
    LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
}

@Preview(name = "Loading", showBackground = true)
@Composable
fun LoadingPreview() {
    ApodTheme {
        Loading()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ApodTheme {
        Loading()
    }
}
