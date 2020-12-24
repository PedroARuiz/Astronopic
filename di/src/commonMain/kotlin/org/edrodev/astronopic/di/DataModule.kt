package org.edrodev.astronopic.di

import org.edrodev.astronopic.data.local.dataSource.di.localDataSourceModule
import org.edrodev.astronopic.data.local.db.di.dbModule
import org.edrodev.astronopic.data.remote.dataSource.di.remoteDataSourceModule
import org.edrodev.astronopic.data.remote.service.di.serviceModule

val dataModules = listOf(
    dbModule,
    localDataSourceModule,
    serviceModule,
    remoteDataSourceModule,
)