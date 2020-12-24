package org.edrodev.astronopic.data.local.db.di

import org.edrodev.astronopic.data.local.db.DriverFactory
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module

internal actual fun Module.driverFactoryBeanDefinition() = single {
    DriverFactory(androidContext()).createDriver()
}