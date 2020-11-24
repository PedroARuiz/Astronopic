package org.edrodev.astronopic.domain.useCase

import kotlinx.datetime.LocalDate
import org.edrodev.astronopic.core.Failure
import org.edrodev.astronopic.core.Result
import org.edrodev.astronopic.domain.model.Apod
import org.edrodev.astronopic.domain.repository.ApodRepository

class GetApod(
    private val apodRepository: ApodRepository
) {
    suspend fun getApod(date: LocalDate): Result<Failure, Apod> =
        apodRepository.getApod(date)
}