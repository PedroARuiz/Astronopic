package org.edrodev.astronopic.di

import org.edrodev.astronopic.data.local.dataSource.ApodLocalDataSource
import org.edrodev.astronopic.data.local.dataSource.ApodLocalDataSourceImpl
import org.edrodev.astronopic.data.local.db.AstronopicDataBase
import org.edrodev.astronopic.data.local.db.DriverFactory
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
            apodRemoteDataSource = get(),
            apodLocalDataSource = get()
        )
    }

    single {
        get<DriverFactory>().createDriver()
    }

    single {
        AstronopicDataBase(
            driver = get()
        )
    }

    single {
        get<AstronopicDataBase>().apodTableQueries
    }

    single<ApodLocalDataSource> {
        ApodLocalDataSourceImpl(
            apodTableQueries = get()
        )
    }
}