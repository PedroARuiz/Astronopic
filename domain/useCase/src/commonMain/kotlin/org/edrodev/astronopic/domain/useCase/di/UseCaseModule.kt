package org.edrodev.astronopic.domain.useCase.di

import org.edrodev.astronopic.domain.useCase.GetApod
import org.koin.dsl.module

val useCaseModule = module {
    single {
        GetApod(
            apodRepository = get()
        )
    }
}