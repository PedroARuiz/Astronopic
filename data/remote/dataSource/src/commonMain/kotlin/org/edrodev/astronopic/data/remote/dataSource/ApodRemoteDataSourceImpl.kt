package org.edrodev.astronopic.data.remote.dataSource

import kotlinx.datetime.LocalDate
import org.edrodev.astronopic.data.remote.model.ApodDTO
import org.edrodev.astronopic.data.remote.service.ApodService

class ApodRemoteDataSourceImpl(
    private val apodService: ApodService
) : ApodRemoteDataSource {
    override suspend fun getApod(date: LocalDate) : ApodDTO =
        apodService.getApod(date)
}