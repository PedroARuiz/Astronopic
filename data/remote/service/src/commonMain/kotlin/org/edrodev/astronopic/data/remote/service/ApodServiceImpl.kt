package org.edrodev.astronopic.data.remote.service

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.features.defaultRequest
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.URLProtocol
import kotlinx.datetime.LocalDate
import kotlinx.serialization.json.Json
import org.edrodev.astronopic.data.remote.model.ApodDTO

class ApodServiceImpl : ApodService {
    private val apiKey = "btLsqqfnKwLMbn3qIZjg1JN51AIGgzDxPk4CPKgS"
    private val client = HttpClient(engine) {
        install(JsonFeature) {
            serializer = KotlinxSerializer(Json {
                ignoreUnknownKeys = true
            })
        }

        defaultRequest {
            parameter("api_key", apiKey)
            url {
                host = "api.nasa.gov"
                protocol = URLProtocol.HTTPS
            }
        }
    }

    override suspend fun getApod(date: LocalDate): ApodDTO =
        client.get {
            parameter("date", date.toString())
            url { encodedPath = "/planetary/apod" }
        }

    /*override suspend fun getConsortia(): List<ConsortiaDTO> =
        client.get<GetConsortiaResponse> {
            url { encodedPath = "/Consorcios/consorcios" }
        }.consorcios

    override suspend fun getConsortium(consortiumId: Int): ConsortiumDTO =
        client.get {
            url { encodedPath = "/Consorcios/$consortiumId/consorcios/consorcio" }
        }*/

}

expect val engine: HttpClientEngine