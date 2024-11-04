package com.example.privatecurrency.retrofit

import android.util.Log
import com.example.privatecurrency.item.AndroidItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitObject {

//    https://api.npoint.io/7159a98ed69e3f84b62b

    val BASE_URL = "https://api.npoint.io/pass/"

    var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var service = retrofit.create(AndroidService::class.java)

    fun getAndroid(key: String?, responseCallback: (AndroidItem?) -> Unit) {
        val call = service.getAndroid(key)

//        CoroutineScope(Dispatchers.Main).launch {
//            val job = CoroutineScope(Dispatchers.IO).async {
//                val execute = call?.execute()
//                execute
//            }
//
//
//            val response = job.await()
//            // TODO...
//        }

        call?.enqueue(object : Callback<AndroidItem?> {
            override fun onResponse(p0: Call<AndroidItem?>, response: Response<AndroidItem?>) {
                Log.d(TAG, "onResponse: $response")
                responseCallback(response.body())
            }

            override fun onFailure(p0: Call<AndroidItem?>, throwable: Throwable) {
                Log.e(TAG, "onFailure: $throwable", )
            }

        })



    }

    val TAG = "XXXXX"


}