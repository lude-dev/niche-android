package com.implude.niche.presentation

import android.app.Application
import com.implude.niche.data.di.networkModule
import com.implude.niche.presentation.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class NicheApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@NicheApplication)
            modules(networkModule, appModule)
        }
    }
}
