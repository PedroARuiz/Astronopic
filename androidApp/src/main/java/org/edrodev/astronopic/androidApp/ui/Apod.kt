package org.edrodev.astronopic.androidApp.ui

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.chrisbanes.accompanist.coil.CoilImage
import kotlinx.datetime.LocalDate
import org.edrodev.astronopic.domain.model.Apod

@Composable
fun Apod(apod: Apod) {
    ScrollableColumn(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize()
    ) {
        CoilImage(
            modifier = Modifier.fillMaxWidth()
                .animateContentSize(),
            data = apod.url,
            contentScale = ContentScale.FillWidth,
            loading = { Loading() }
        )
        Text(
            modifier = Modifier.padding(16.dp)
                .animateContentSize(),
            text = apod.explanation
        )
    }
}

@Preview(name = "Apod")
@Composable
fun ApodPreview() {
    ApodTheme {
        Apod(apodFake)
    }
}

val apodFake = Apod(
    copyright = null,
    explanation = "Sample explanation",
    date = LocalDate(2020, 12, 11),
    hdurl = null,
    title = "Sample title",
    url = ""
)