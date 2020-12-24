package org.edrodev.astronopic.presentation.apod.di

import org.edrodev.astronopic.presentation.apod.ApodViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.definition.BeanDefinition
import org.koin.core.module.Module
import org.koin.dsl.module

internal actual fun Module.apodViewModelDefinition(): BeanDefinition<ApodViewModel> = viewModel {
        ApodViewModel(
            getApod = get()
        )
    }