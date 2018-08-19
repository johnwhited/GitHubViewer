package com.john.githubviewer.application

import com.john.githubviewer.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

@Suppress("unused")
class GitHubViewerApplication : DaggerApplication() {

    private val appComponent = DaggerAppComponent.builder()
            .application(this)
            .build()

    override fun onCreate() {
        super.onCreate()

        appComponent.inject(this)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return appComponent
    }
}
