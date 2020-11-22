package org.edrodev.astronopic.data.remote.service

import org.edrodev.astronopic.data.remote.model.ApodDTO

interface ApodService {
    suspend fun getApod() : ApodDTO
}