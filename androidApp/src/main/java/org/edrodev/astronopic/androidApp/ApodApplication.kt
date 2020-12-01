package org.edrodev.astronopic.androidApp

import android.app.Application
import org.edrodev.astronopic.di.initDI
import org.koin.android.ext.koin.androidContext

class ApodApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initDI {
            androidContext(applicationContext)
        }
    }
}