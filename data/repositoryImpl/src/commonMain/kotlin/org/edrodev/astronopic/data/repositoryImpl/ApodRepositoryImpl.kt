package org.edrodev.astronopic.data.repositoryImpl

import kotlinx.datetime.LocalDate
import org.edrodev.astronopic.core.Failure
import org.edrodev.astronopic.core.Result
import org.edrodev.astronopic.core.ifSuccess
import org.edrodev.astronopic.core.mapSuccess
import org.edrodev.astronopic.data.remote.dataSource.ApodRemoteDataSource
import org.edrodev.astronopic.data.local.dataSource.ApodLocalDataSource
import org.edrodev.astronopic.data.repositoryImpl.mapper.toApod
import org.edrodev.astronopic.data.repositoryImpl.mapper.toApodEntity
import org.edrodev.astronopic.domain.model.Apod
import org.edrodev.astronopic.domain.repository.ApodRepository

class ApodRepositoryImpl(
    private val apodRemoteDataSource: ApodRemoteDataSource,
    private val apodLocalDataSource: ApodLocalDataSource,
) : ApodRepository {
    override suspend fun getApod(date: LocalDate) : Result<Failure, Apod> =
        apodLocalDataSource.getApod(date).takeIf { it is Result.Success }?.mapSuccess {
            it.toApod()
        } ?: apodRemoteDataSource.getApod(date)
            .ifSuccess {
                apodLocalDataSource.insertApod(it.toApodEntity())
            }.mapSuccess { it.toApod() }
}