package com.john.githubviewer.viewmodel

import android.arch.lifecycle.ViewModel
import android.content.Context
import com.john.githubviewer.service.ugithub.repository.UGitHubRepository
import javax.inject.Inject

class TrendingProjectsViewModel @Inject
constructor(private val uGitHubRepository: UGitHubRepository): ViewModel() {

    fun getTrendingProjects(context: Context) = uGitHubRepository.getTrendingProjects(context)
}
