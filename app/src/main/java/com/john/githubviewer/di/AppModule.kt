package com.john.githubviewer.di

import com.john.githubviewer.service.github.GitHubService
import com.john.githubviewer.service.ugithub.UGitHubService
import dagger.Module
import javax.inject.Singleton
import dagger.Provides

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideGitHubService(): GitHubService {
        return GitHubService.create()
    }

    @Provides
    @Singleton
    fun provideUGitHubService(): UGitHubService {
        return UGitHubService.create()
    }
}
