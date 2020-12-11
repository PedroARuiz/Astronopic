package org.edrodev.astronopic.androidApp.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

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
