package com.john.githubviewer.di

import com.john.githubviewer.view.ui.activity.HostActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @Suppress("unused")
    @ContributesAndroidInjector(modules = [(HostActivityModule::class)])
    internal abstract fun bindHostActivity(): HostActivity
}
