package org.edrodev.astronopic.data.local.db.di

import com.squareup.sqldelight.db.SqlDriver
import org.edrodev.astronopic.data.local.db.AstronopicDataBase
import org.koin.core.definition.BeanDefinition
import org.koin.core.module.Module
import org.koin.dsl.module

internal expect fun Module.driverFactoryBeanDefinition(): BeanDefinition<SqlDriver>

val dbModule = module {
    driverFactoryBeanDefinition()

    single {
        AstronopicDataBase(
            driver = get()
        )
    }

    single {
        get<AstronopicDataBase>().apodTableQueries
    }
}