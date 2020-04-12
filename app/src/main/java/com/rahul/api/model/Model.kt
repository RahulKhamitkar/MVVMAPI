package com.rahul.api.model

import com.google.gson.annotations.SerializedName


data class Model(@SerializedName("ad")
                 val ad: Ad,
                 @SerializedName("data")
                 val data: Data)

data class Data(@SerializedName("last_name")
                val lastName: String = "",
                @SerializedName("id")
                val id: Int = 0,
                @SerializedName("avatar")
                val avatar: String = "",
                @SerializedName("first_name")
                val firstName: String = "",
                @SerializedName("email")
                val email: String = "")

data class Ad(@SerializedName("company")
              val company: String = "",
              @SerializedName("text")
              val text: String = "",
              @SerializedName("url")
              val url: String = "")