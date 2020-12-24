package org.edrodev.astronopic.data.remote.dataSource.di

import org.edrodev.astronopic.data.remote.dataSource.ApodRemoteDataSource
import org.edrodev.astronopic.data.remote.dataSource.ApodRemoteDataSourceImpl
import org.koin.dsl.module

val remoteDataSourceModule = module {
    single<ApodRemoteDataSource> {
        ApodRemoteDataSourceImpl(
            apodService = get()
        )
    }
}
