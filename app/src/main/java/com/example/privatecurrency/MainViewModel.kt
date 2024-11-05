package com.example.privatecurrency

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.privatecurrency.item.CurrencyItem
import com.example.privatecurrency.retrofit.RetrofitPrivate

class MainViewModel : ViewModel() {

    private val retrofitObject: RetrofitPrivate = RetrofitPrivate()

    private val _currencyList = MutableLiveData<List<CurrencyItem>>(listOf())
    val currencyList : LiveData<List<CurrencyItem>>
        get() = _currencyList


    fun fetchData() {
        retrofitObject.getCurrencyExchange {
            if (it == null) {
                _currencyList.value = listOf()
            } else {
                _currencyList.value = it
            }
        }
    }
}