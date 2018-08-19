package com.john.githubviewer.service.github.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import com.john.githubviewer.R
import com.john.githubviewer.model.ProjectDetails
import com.john.githubviewer.model.Resource
import com.john.githubviewer.model.TrendingProject
import com.john.githubviewer.service.github.GitHubService
import com.john.githubviewer.service.github.pojo.ProjectDetailsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GitHubRepository @Inject
constructor(private val gitHubService: GitHubService) {

    fun getProjectsDetails(trendingProject: TrendingProject, context: Context): LiveData<Resource<ProjectDetails>> {
        val result = MutableLiveData<Resource<ProjectDetails>>()

        if (trendingProject.author == null || trendingProject.repository == null) {
            result.value = Resource.error(context.getString(R.string.network_error_message), null)
        } else {
            gitHubService.getProjectDetails(trendingProject.author, trendingProject.repository).enqueue(object : Callback<ProjectDetailsResponse> {

                override fun onFailure(call: Call<ProjectDetailsResponse>?, t: Throwable?) {
                    result.value = Resource.error(context.getString(R.string.network_error_message), null)
                }

                override fun onResponse(call: Call<ProjectDetailsResponse>?, response: Response<ProjectDetailsResponse>?) {
                    val responseBody = response?.body()
                    if (responseBody != null && response.isSuccessful) {
                        val project = ProjectDetails(trendingProject.repository, responseBody.description, responseBody.language,
                                responseBody.watchersCount, responseBody.openIssuesCount, responseBody.createdAt,
                                responseBody.updatedAt, responseBody.cloneUrl)
                        result.value = Resource.success(project)
                    } else {
                        result.value = Resource.error(context.getString(R.string.network_error_message), null)
                    }
                }
            })
        }
        return result
    }
}
