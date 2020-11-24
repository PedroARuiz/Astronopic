package org.edrodev.astronopic.data.remote.dataSource

import kotlinx.datetime.LocalDate
import org.edrodev.astronopic.core.Failure
import org.edrodev.astronopic.core.Result
import org.edrodev.astronopic.data.remote.dto.ApodDTO

interface ApodRemoteDataSource {
    suspend fun getApod(date: LocalDate) : Result<Failure, ApodDTO>
}