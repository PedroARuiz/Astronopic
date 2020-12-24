package org.edrodev.astronopic.data.remote.service.di

import org.edrodev.astronopic.data.remote.service.ApodService
import org.edrodev.astronopic.data.remote.service.ApodServiceImpl
import org.edrodev.astronopic.data.remote.service.client.createHttpClient
import org.edrodev.astronopic.data.remote.service.client.createSerializer
import org.edrodev.astronopic.data.remote.service.client.engine
import org.edrodev.astronopic.data.remote.service.client.json
import org.koin.dsl.module

val serviceModule = module {

    single {
        engine
    }

    single {
        json
    }

    single {
        createSerializer(
            json = get()
        )
    }

    single {
        val apiKey = "btLsqqfnKwLMbn3qIZjg1JN51AIGgzDxPk4CPKgS"
        createHttpClient(
            engine = get(),
            serializer = get(),
            apiKey = apiKey
        )
    }

    single<ApodService> {
        ApodServiceImpl(
            client = get()
        )
    }
}
