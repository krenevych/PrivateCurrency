package com.example.privatecurrency.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.privatecurrency.domain.item.CurrencyItem
import com.example.privatecurrency.domain.repository.Repository
import com.example.privatecurrency.domain.usecase.GetLiveDataUseCase
import com.example.privatecurrency.domain.usecase.UpdateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    repository: Repository
) : ViewModel() {

    private val getLiveDataUseCase = GetLiveDataUseCase(repository)
    private val updateUseCase = UpdateUseCase(repository)

    val liveData: LiveData<List<CurrencyItem>>
        get() = getLiveDataUseCase()

    fun fetchData() = updateUseCase()
}