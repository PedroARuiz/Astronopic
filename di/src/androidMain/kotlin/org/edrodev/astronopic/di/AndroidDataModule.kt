package org.edrodev.astronopic.di

import org.edrodev.astronopic.data.local.db.DriverFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val androidDataModule = module(override = true) {
    single {
        DriverFactory(context = androidContext())
    }
}