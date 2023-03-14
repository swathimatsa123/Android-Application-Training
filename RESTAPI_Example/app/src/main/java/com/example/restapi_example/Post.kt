package com.example.restapi_example

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Post {
    @SerializedName("title")
    @Expose
    var title: String? = null

    @SerializedName("body")
    @Expose
    var body: String? = null

    @SerializedName("userId")
    @Expose
    var userId: Int? = null

    @SerializedName("id")
    @Expose
    var id: Int? = null
}