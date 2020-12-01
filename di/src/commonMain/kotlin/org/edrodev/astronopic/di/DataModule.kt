package org.edrodev.astronopic.di

import org.edrodev.astronopic.data.remote.dataSource.ApodRemoteDataSource
import org.edrodev.astronopic.data.remote.dataSource.ApodRemoteDataSourceImpl
import org.edrodev.astronopic.data.remote.service.ApodService
import org.edrodev.astronopic.data.remote.service.ApodServiceImpl
import org.edrodev.astronopic.data.repositoryImpl.ApodRepositoryImpl
import org.edrodev.astronopic.domain.repository.ApodRepository
import org.koin.dsl.module

val dataModule = module {
    single<ApodService> {
        ApodServiceImpl()
    }

    single<ApodRemoteDataSource> {
        ApodRemoteDataSourceImpl(
            apodService = get()
        )
    }

    single<ApodRepository> {
        ApodRepositoryImpl(
            apodRemoteDataSource = get()
        )
    }
}