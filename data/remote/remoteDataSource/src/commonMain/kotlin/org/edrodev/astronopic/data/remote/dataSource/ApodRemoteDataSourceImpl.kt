package org.edrodev.astronopic.data.remote.dataSource

import kotlinx.datetime.LocalDate
import org.edrodev.astronopic.core.Failure
import org.edrodev.astronopic.core.Result
import org.edrodev.astronopic.core.mapFailure
import org.edrodev.astronopic.data.remote.dto.ApodDTO
import org.edrodev.astronopic.data.remote.service.ApodService
import org.edrodev.astronopic.data.remote.service.NetworkFailure
import org.edrodev.astronopic.data.remote.service.toFailure

internal class ApodRemoteDataSourceImpl(
    private val apodService: ApodService
) : ApodRemoteDataSource {
    override suspend fun getApod(date: LocalDate) : Result<Failure, ApodDTO> =
        apodService.getApod(date).mapFailure(NetworkFailure::toFailure)
}