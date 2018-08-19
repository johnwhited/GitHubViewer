package com.john.githubviewer.viewmodel

import android.arch.lifecycle.ViewModel
import android.content.Context
import com.john.githubviewer.model.TrendingProject
import com.john.githubviewer.service.github.repository.GitHubRepository
import javax.inject.Inject

class ProjectDetailsViewModel @Inject
constructor(private val gitHubRepository: GitHubRepository): ViewModel() {

    fun getProjectsDetails(trendingProject: TrendingProject, context: Context) =
            gitHubRepository.getProjectsDetails(trendingProject, context)
}
