package org.edrodev.astronopic.data.remote.service.client

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.features.ClientRequestException
import io.ktor.client.features.defaultRequest
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.JsonSerializer
import io.ktor.client.request.parameter
import io.ktor.http.URLProtocol
import org.edrodev.astronopic.core.Result
import org.edrodev.astronopic.core.asFailure
import org.edrodev.astronopic.core.asSuccess
import org.edrodev.astronopic.data.remote.service.NetworkFailure

internal expect val engine: HttpClientEngine

internal fun createHttpClient(
    engine: HttpClientEngine,
    serializer: JsonSerializer,
    apiKey: String
): HttpClient = HttpClient(engine = engine) {
    install(JsonFeature) {
        this.serializer = serializer
    }

    defaultRequest {
        parameter("api_key", apiKey)
        url {
            host = "api.nasa.gov"
            protocol = URLProtocol.HTTPS
        }
    }
}

internal inline fun <T>executeCatching(block: () -> T): Result<NetworkFailure, T> = try {
    block().asSuccess()
} catch (e: ClientRequestException) {
    when(e.response.status.value) {
        400 ->NetworkFailure.NotAvailable
        else -> NetworkFailure.Unknown
    }.asFailure()
} catch (e: Exception) {
    NetworkFailure.Unknown.asFailure()
}