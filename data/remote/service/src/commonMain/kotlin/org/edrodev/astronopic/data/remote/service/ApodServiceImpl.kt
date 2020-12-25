package org.edrodev.astronopic.data.remote.service

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import kotlinx.datetime.LocalDate
import org.edrodev.astronopic.core.Result
import org.edrodev.astronopic.data.remote.dto.ApodDTO
import org.edrodev.astronopic.data.remote.service.client.executeCatching

internal class ApodServiceImpl(
    private val client: HttpClient
) : ApodService {
    override suspend fun getApod(date: LocalDate): Result<NetworkFailure, ApodDTO> = executeCatching {
        client.get {
            parameter("date", date.toString())
            url { encodedPath = "/planetary/apod" }
        }
    }

}