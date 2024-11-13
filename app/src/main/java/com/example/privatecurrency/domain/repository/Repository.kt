package com.example.privatecurrency.domain.repository

import androidx.lifecycle.LiveData
import com.example.privatecurrency.domain.item.CurrencyItem

interface Repository {
    val liveData : LiveData<List<CurrencyItem>>
    fun update()
}