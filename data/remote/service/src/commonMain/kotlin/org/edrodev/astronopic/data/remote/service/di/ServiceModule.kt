package org.edrodev.astronopic.data.remote.service.di

import org.edrodev.astronopic.data.remote.service.ApodService
import org.edrodev.astronopic.data.remote.service.ApodServiceImpl
import org.edrodev.astronopic.data.remote.service.client.ServiceConstants
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
        createHttpClient(
            engine = get(),
            serializer = get(),
            apiKey = ServiceConstants.apiKey
        )
    }

    single<ApodService> {
        ApodServiceImpl(
            client = get()
        )
    }
}
