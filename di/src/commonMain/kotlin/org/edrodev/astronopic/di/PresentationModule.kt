package org.edrodev.astronopic.di

import org.edrodev.astronopic.presentation.apod.ApodViewModel
import org.koin.dsl.module

val presentationModule = module {
    factory {
        ApodViewModel(
            getApod = get()
        )
    }
}