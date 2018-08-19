package com.john.githubviewer.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.john.githubviewer.factory.ViewModelFactory
import com.john.githubviewer.viewmodel.ProjectDetailsViewModel
import com.john.githubviewer.viewmodel.TrendingProjectsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class ViewModelModule {
    @Suppress("unused")
    @Binds
    @IntoMap
    @ViewModelKey(TrendingProjectsViewModel::class)
    internal abstract fun bindTrendingProjectsViewModel(trendingProjectsViewModel: TrendingProjectsViewModel): ViewModel

    @Suppress("unused")
    @Binds
    @IntoMap
    @ViewModelKey(ProjectDetailsViewModel::class)
    internal abstract fun bindProjectDetailsViewModel(projectDetailsViewModel: ProjectDetailsViewModel): ViewModel

    @Suppress("unused")
    @Binds
    internal abstract fun bindViewModelFactory(appViewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}
