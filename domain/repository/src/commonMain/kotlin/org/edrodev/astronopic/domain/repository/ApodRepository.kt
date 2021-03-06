package org.edrodev.astronopic.domain.repository

import kotlinx.datetime.LocalDate
import org.edrodev.astronopic.core.Failure
import org.edrodev.astronopic.core.Result
import org.edrodev.astronopic.domain.model.Apod

interface ApodRepository {
    suspend fun getApod(date: LocalDate): Result<Failure, Apod>
}