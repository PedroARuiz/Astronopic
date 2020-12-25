package org.edrodev.astronopic.data.local.dataSource

import kotlinx.datetime.LocalDate
import org.edrodev.astronopic.core.Failure
import org.edrodev.astronopic.core.Result
import org.edrodev.astronopic.core.runCatchingFailure
import orgedrodevastronopicdatalocaldb.ApodEntity
import orgedrodevastronopicdatalocaldb.ApodTableQueries

internal class ApodLocalDataSourceImpl(
    private val apodTableQueries: ApodTableQueries
) : ApodLocalDataSource {

    override suspend fun insertApod(apodEntity: ApodEntity): Result<Failure, Unit> = runCatchingFailure {
        apodTableQueries.insert(apodEntity)
    }

    override suspend fun getApod(date: LocalDate) : Result<Failure, ApodEntity> = runCatchingFailure {
        apodTableQueries.selectByDate(date.toString()).executeAsOne()
    }
}