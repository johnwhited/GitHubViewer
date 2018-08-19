package com.john.githubviewer.service.github.pojo

import com.google.gson.annotations.SerializedName

data class ProductLicense(
        @SerializedName("key")
        var key: String? = null,
        @SerializedName("name")
        var name: String? = null,
        @SerializedName("node_id")
        var nodeId: String? = null,
        @SerializedName("spdx_id")
        var spdxId: String? = null,
        @SerializedName("url")
        var url: String? = null
)
