package com.iot.jarvis.application

import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MobileJarvisApplication: BaseJarvisApplication() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MobileJarvisApplication)
        }
    }
}