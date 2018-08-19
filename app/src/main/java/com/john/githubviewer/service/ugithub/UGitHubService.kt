package com.john.githubviewer.service.ugithub

import com.john.githubviewer.service.ugithub.pojo.TrendingProjectsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit

interface UGitHubService {

    @GET("developers?language=java&since=weekly")
    fun getProjectList(): Call<List<TrendingProjectsResponse>>

    companion object Factory {
        private const val HTTPS_API_UGITHUB_URL = "https://github-trending-api.now.sh/"

        fun create(): UGitHubService {
            val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(HTTPS_API_UGITHUB_URL)
                    .build()

            return retrofit.create<UGitHubService>(UGitHubService::class.java)
        }
    }
}
