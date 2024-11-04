package com.example.privatecurrency.item


import com.google.gson.annotations.SerializedName

data class AndroidItem(
    @SerializedName("Android")
    val android: String? = null,
    @SerializedName("Hello")
    val hello: String? = null,
    @SerializedName("version")
    val version: Int? = null
)