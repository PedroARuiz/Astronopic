package org.edrodev.astronopic.data.remote.service

import kotlinx.datetime.LocalDate
import org.edrodev.astronopic.data.remote.model.ApodDTO

interface ApodService {
    suspend fun getApod(date: LocalDate) : ApodDTO
}