package org.edrodev.astronopic.di

import org.edrodev.astronopic.data.repositoryImpl.di.repositoryModule
import org.edrodev.astronopic.domain.useCase.di.useCaseModule

val domainModules = listOf(
    repositoryModule,
    useCaseModule
)