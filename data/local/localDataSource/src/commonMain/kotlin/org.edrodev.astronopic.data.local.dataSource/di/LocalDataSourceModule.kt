package org.edrodev.astronopic.data.local.dataSource.di

import org.edrodev.astronopic.data.local.dataSource.ApodLocalDataSource
import org.edrodev.astronopic.data.local.dataSource.ApodLocalDataSourceImpl
import org.koin.dsl.module

val localDataSourceModule = module {
    single<ApodLocalDataSource> {
        ApodLocalDataSourceImpl(
            apodTableQueries = get()
        )
    }
}
