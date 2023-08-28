package com.example.gipphyapplication

import android.app.Application
import com.example.data.di.dataModule
import com.example.domain.di.domainModule
import com.example.gipphyapplication.di.vmModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(domainModule, dataModule, vmModule)
        }
    }
}
