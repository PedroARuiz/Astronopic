package org.edrodev.astronopic.di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initDI(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(
        domainModule,
        dataModule,
        presentationModule
    )
}

// called by iOS etc
fun initDI() = initDI{}
