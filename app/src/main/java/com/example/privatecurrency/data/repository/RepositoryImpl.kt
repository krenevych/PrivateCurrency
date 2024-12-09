package com.example.privatecurrency.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.privatecurrency.data.retrofit.ServicePrivate
import com.example.privatecurrency.domain.item.CurrencyItem
import com.example.privatecurrency.domain.repository.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


class RepositoryImpl @Inject constructor(
    private val service: ServicePrivate
) : Repository {

    private val _currencyList = MutableLiveData<List<CurrencyItem>>(listOf())
    override val liveData: LiveData<List<CurrencyItem>>
        get() = _currencyList

    override fun update() {
        getCurrencyExchange {
            if (it == null) {
                _currencyList.value = listOf()
            } else {
                _currencyList.value = it
            }
        }
    }


    private fun getCurrencyExchange(resultCallback: (List<CurrencyItem>?) -> Unit) {
        // TODO: викликати сервіс і асинхронно запросити дані
        val call = service.getCurrencyExchange(null, 5)

        call?.enqueue(object : Callback<List<CurrencyItem>?> {
            override fun onResponse(
                p0: Call<List<CurrencyItem>?>,
                response: Response<List<CurrencyItem>?>
            ) {
                resultCallback(response.body())
            }

            override fun onFailure(p0: Call<List<CurrencyItem>?>, throwable: Throwable) {
                resultCallback(null)
            }

        })
    }
}