package com.john.githubviewer.service.ugithub.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import com.john.githubviewer.R
import com.john.githubviewer.model.Resource
import com.john.githubviewer.model.TrendingProject
import com.john.githubviewer.service.ugithub.UGitHubService
import com.john.githubviewer.service.ugithub.pojo.TrendingProjectsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UGitHubRepository @Inject
constructor(private val uGitHubService: UGitHubService) {

    fun getTrendingProjects(context: Context): LiveData<Resource<List<TrendingProject>>> {
        val result = MutableLiveData<Resource<List<TrendingProject>>>()

        uGitHubService.getProjectList().enqueue(object : Callback<List<TrendingProjectsResponse>> {

            override fun onFailure(call: Call<List<TrendingProjectsResponse>>?, t: Throwable?) {
                result.value = Resource.error(context.getString(R.string.network_error_message), null)
            }

            override fun onResponse(call: Call<List<TrendingProjectsResponse>>?, response: Response<List<TrendingProjectsResponse>>?) {
                val responseBody = response?.body()
                if (responseBody != null && response.isSuccessful) {
                    val trendingProjectList: ArrayList<TrendingProject> = ArrayList()
                    for (tpr: TrendingProjectsResponse in responseBody) {
                        val project = TrendingProject(tpr.name, tpr.username, tpr.repo?.name, tpr.repo?.description)
                        trendingProjectList.add(project)
                    }
                    result.value = Resource.success(trendingProjectList)
                } else {
                    result.value = Resource.error(context.getString(R.string.network_error_message), null)
                }
            }
        })
        return result
    }
}
