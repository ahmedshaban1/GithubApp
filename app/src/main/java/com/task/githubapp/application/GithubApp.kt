package com.task.githubapp.application

import android.app.Application
import com.task.local.di.localModule
import com.task.remote.di.getRemoteModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class GithubApp: Application() {
    override fun onCreate() {
        super.onCreate()

        // init koin di
        startKoin {
            androidLogger()
            androidContext(this@GithubApp)
            modules(listOf(getRemoteModule("https://api.github.com/"), localModule/*, githubModule*/))
        }
    }
}