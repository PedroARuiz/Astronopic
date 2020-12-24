package org.edrodev.astronopic.androidApp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun FailureNotFound() {
    Column {
        Text(modifier = Modifier.align(Alignment.CenterHorizontally),
            text = "Pic of the day not found")
    }
}

@Preview(name = "Failure.NotFound", showBackground = true)
@Composable
private fun FailureNotFoundPreview() {
    FailureNotFound()
}

@Composable
fun FailureUnknown() {
    Column {
        Text(modifier = Modifier.align(Alignment.CenterHorizontally),
            text = "Something went wrong")
    }
}

@Preview(name = "Failure.Unknown", showBackground = true)
@Composable
private fun FailureUnknownPreview() {
    FailureUnknown()
}