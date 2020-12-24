package org.edrodev.astronopic.data.repositoryImpl.di

import org.edrodev.astronopic.data.repositoryImpl.ApodRepositoryImpl
import org.edrodev.astronopic.domain.repository.ApodRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<ApodRepository> {
        ApodRepositoryImpl(
            apodRemoteDataSource = get(),
            apodLocalDataSource = get()
        )
    }
}
