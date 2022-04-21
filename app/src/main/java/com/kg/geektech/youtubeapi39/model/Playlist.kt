package com.kg.geektech.youtubeapi39.model

import com.google.gson.annotations.SerializedName

data class Playlist(
    val kind: String? = null,
    @SerializedName("etag")
    val tag: String? = null,
)