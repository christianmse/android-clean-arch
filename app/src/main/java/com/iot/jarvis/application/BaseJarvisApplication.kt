package com.iot.jarvis.application

import android.app.Application
import com.iot.jarvis.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin

open class BaseJarvisApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BaseJarvisApplication)
            loadKoinModules(appModule)
        }
    }
}