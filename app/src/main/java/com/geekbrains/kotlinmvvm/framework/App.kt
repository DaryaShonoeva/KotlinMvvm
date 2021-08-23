package com.geekbrains.kotlinmvvm.framework

import android.app.Application
import com.geekbrains.kotlinmvvm.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(appModule)
            
        }
    }
}