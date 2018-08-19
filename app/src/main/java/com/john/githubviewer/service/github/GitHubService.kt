package com.john.githubviewer.service.github

import com.john.githubviewer.service.github.pojo.ProjectDetailsResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {

    @GET("/repos/{user}/{reponame}")
    fun getProjectDetails(@Path("user") user: String, @Path("reponame") projectName: String): Call<ProjectDetailsResponse>

    companion object Factory {
        private const val HTTPS_API_GITHUB_URL = "https://api.github.com/"

        fun create(): GitHubService {
            val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(HTTPS_API_GITHUB_URL)
                    .build()

            return retrofit.create<GitHubService>(GitHubService::class.java)
        }
    }
}
