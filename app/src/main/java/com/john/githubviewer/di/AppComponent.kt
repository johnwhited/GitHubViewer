package com.john.githubviewer.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(AndroidSupportInjectionModule::class), (ActivityBindingModule::class),
    (HostActivityModule::class), (ViewModelModule::class), (AppModule::class)])
interface AppComponent : AndroidInjector<DaggerApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): AppComponent.Builder
        fun build(): AppComponent
    }

    override fun inject(instance: DaggerApplication)
}
