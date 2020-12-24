package org.edrodev.astronopic.data.remote.service.client

import io.ktor.client.features.json.JsonSerializer
import io.ktor.client.features.json.serializer.KotlinxSerializer
import kotlinx.serialization.json.Json

internal val json: Json = Json {
    ignoreUnknownKeys = true
}

internal fun createSerializer(json: Json): JsonSerializer = KotlinxSerializer(
    json = json
)