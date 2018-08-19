package com.john.githubviewer.service.ugithub.pojo

import com.google.gson.annotations.SerializedName

data class TrendingProjectRepository(
        @SerializedName("name")
        val name: String? = null,
        @SerializedName("description")
        val description: String? = null,
        @SerializedName("url")
        val url: String? = null
)
