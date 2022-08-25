package com.pedromoura.itau

import android.app.Application
import com.pedromoura.itau.di.githubModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class GithubApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@GithubApplication)
            modules(githubModule)
        }
    }
}