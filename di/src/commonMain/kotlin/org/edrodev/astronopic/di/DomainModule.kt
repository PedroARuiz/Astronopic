package org.edrodev.astronopic.di

import org.edrodev.astronopic.domain.useCase.GetApod
import org.koin.dsl.module

val domainModule = module {
    single {
        GetApod(
            apodRepository = get()
        )
    }
}