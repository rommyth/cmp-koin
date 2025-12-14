package org.example.cmphelloworld

import android.app.Application
import org.example.cmphelloworld.core.di.initKoin
import org.koin.android.ext.koin.androidContext

class MyApp: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@MyApp)
        }
    }
}