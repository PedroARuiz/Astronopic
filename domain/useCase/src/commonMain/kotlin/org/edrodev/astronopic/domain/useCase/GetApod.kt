package org.edrodev.astronopic.domain.useCase

import kotlinx.datetime.LocalDate
import org.edrodev.astronopic.domain.model.Apod
import org.edrodev.astronopic.domain.repository.ApodRepository

class GetApod(
    private val apodRepository: ApodRepository
) {
    suspend fun getApod(date: LocalDate): Apod =
        apodRepository.getApod(date)
}