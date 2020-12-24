package org.edrodev.astronopic.presentation.apod.di

import org.edrodev.astronopic.presentation.apod.ApodViewModel
import org.koin.core.definition.BeanDefinition
import org.koin.core.module.Module
import org.koin.dsl.module

internal expect fun Module.apodViewModelDefinition(): BeanDefinition<ApodViewModel>

val presentationApodModule = module {
    apodViewModelDefinition()
}
