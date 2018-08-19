package com.john.githubviewer.service.ugithub.pojo

import com.google.gson.annotations.SerializedName

data class TrendingProjectsResponse(
        @SerializedName("repo")
        val repo: TrendingProjectRepository? = null,
        @SerializedName("name")
        val name: String? = null,
        @SerializedName("avatar")
        val avatar: String? = null,
        @SerializedName("url")
        val url: String? = null,
        @SerializedName("username")
        val username: String? = null
)