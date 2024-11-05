package com.example.privatecurrency.retrofit

import com.example.privatecurrency.item.AndroidItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitObject {

//    https://api.npoint.io/7159a98ed69e3f84b62b

    private val BASE_URL = "https://api.npoint.io/"

    private var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private var service = retrofit.create(AndroidService::class.java)

    private var coroutineScope : CoroutineScope?= null

    fun getAndroid(key: String?, responseCallback: (AndroidItem?) -> Unit) {
        val call = service.getAndroid(key)

        coroutineScope = CoroutineScope(Dispatchers.Main).apply {
            launch {
                val job = CoroutineScope(Dispatchers.IO).async {
                    val execute = call?.execute()
                    execute
                }


                val response = job.await()
                responseCallback.invoke(response?.body())
            }

//        call?.enqueue(object : Callback<AndroidItem?> {
//            override fun onResponse(p0: Call<AndroidItem?>, response: Response<AndroidItem?>) {
//                Log.d(TAG, "onResponse: $response")
//                responseCallback(response.body())
//            }
//
//            override fun onFailure(p0: Call<AndroidItem?>, throwable: Throwable) {
//                Log.e(TAG, "onFailure: $throwable", )
//            }
//
//        })
        }
    }

//    fun getOtherInfo(callback: (AndroidItem?) -> Unit) {
//        service.getOtherInfo("hello", 2024)
//
//    }

    fun onStop() {
        coroutineScope?.cancel()
    }

    val TAG = "XXXXX"


}