package com.example.privatecurrency.data.retrofit

import com.example.privatecurrency.domain.item.CurrencyItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ServicePrivate {

    //    https://api.privatbank.ua/p24api/pubinfo?exchange&coursid=5

    @GET("p24api/pubinfo")
    fun getCurrencyExchange(
        @Query("exchange") exchange: String?,
        @Query("coursid") courseId: Int
    ): Call<List<CurrencyItem>?>?
}