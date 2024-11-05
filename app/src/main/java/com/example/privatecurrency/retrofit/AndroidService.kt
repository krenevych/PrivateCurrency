package com.example.privatecurrency.retrofit

import com.example.privatecurrency.item.AndroidItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface AndroidService {
        @GET("{key}")
        fun getAndroid(@Path("key") key: String?): Call<AndroidItem?>?

//        @GET("{path}/otherInfo/{path2}")
//        fun getOtherInfo(@Path("path") key: String?, @Path("path2") int: Int): Call<AndroidItem?>?
//        // https://api.npoint.io/hello/otherInfo/2024

}