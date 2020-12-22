package org.edrodev.astronopic.data.local.dataSource

import kotlinx.datetime.LocalDate
import org.edrodev.astronopic.core.Failure
import org.edrodev.astronopic.core.Result
import orgedrodevastronopicdatalocaldb.ApodEntity

interface ApodLocalDataSource {
    suspend fun insertApod(apodEntity: ApodEntity) : Result<Failure, Unit>
    suspend fun getApod(date: LocalDate) : Result<Failure, ApodEntity>
}