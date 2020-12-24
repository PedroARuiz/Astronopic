package org.edrodev.astronopic.data.remote.service.di

import org.edrodev.astronopic.data.remote.service.ApodService
import org.edrodev.astronopic.data.remote.service.ApodServiceImpl
import org.koin.dsl.module

val serviceModule = module {
    single<ApodService> {
        ApodServiceImpl()
    }
}
