package com.example.privatecurrency.domain.usecase

import androidx.lifecycle.LiveData
import com.example.privatecurrency.domain.item.CurrencyItem
import com.example.privatecurrency.domain.repository.Repository

class GetLiveDataUseCase(
    private val repository: Repository
) {

    operator fun invoke(): LiveData<List<CurrencyItem>> {
        return repository.liveData
    }

}