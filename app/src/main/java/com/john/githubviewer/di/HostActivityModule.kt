package com.john.githubviewer.di

import com.john.githubviewer.view.ui.fragment.ProjectDetailsFragment
import com.john.githubviewer.view.ui.fragment.TrendingProjectsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class HostActivityModule {

    @Suppress("unused")
    @ContributesAndroidInjector
    internal abstract fun contributeProjectDetailsFragment(): ProjectDetailsFragment

    @Suppress("unused")
    @ContributesAndroidInjector
    internal abstract fun contributeTrendingProjectsFragment(): TrendingProjectsFragment
}
