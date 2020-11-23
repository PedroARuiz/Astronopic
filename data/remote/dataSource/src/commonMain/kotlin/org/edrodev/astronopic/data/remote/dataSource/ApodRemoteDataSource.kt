package org.edrodev.astronopic.data.remote.dataSource

import kotlinx.datetime.LocalDate
import org.edrodev.astronopic.data.remote.model.ApodDTO

interface ApodRemoteDataSource {
    suspend fun getApod(date: LocalDate) : ApodDTO
}