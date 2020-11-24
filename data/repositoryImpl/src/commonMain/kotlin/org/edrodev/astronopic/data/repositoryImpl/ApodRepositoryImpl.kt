package org.edrodev.astronopic.data.repositoryImpl

import kotlinx.datetime.LocalDate
import org.edrodev.astronopic.core.Failure
import org.edrodev.astronopic.core.Result
import org.edrodev.astronopic.core.mapSuccess
import org.edrodev.astronopic.data.remote.dataSource.ApodRemoteDataSource
import org.edrodev.astronopic.data.remote.dto.ApodDTO
import org.edrodev.astronopic.data.repositoryImpl.mapper.toApod
import org.edrodev.astronopic.domain.model.Apod
import org.edrodev.astronopic.domain.repository.ApodRepository

class ApodRepositoryImpl(
    private val apodRemoteDataSource: ApodRemoteDataSource
) : ApodRepository {
    override suspend fun getApod(date: LocalDate) : Result<Failure, Apod> =
        apodRemoteDataSource.getApod(date).mapSuccess { it.toApod() }
}