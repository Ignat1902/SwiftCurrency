package com.example.swiftcurrency.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.swiftcurrency.core.NetworkResult
import com.example.swiftcurrency.data.repository.CurrencyRepository
import com.example.swiftcurrency.entity.CurrencyResponse
import kotlinx.coroutines.launch
import javax.inject.Inject

class ExchangeRateViewModel @Inject constructor(private val currencyRepository: CurrencyRepository) :
    ViewModel() {

    private var _exchangeRate = MutableLiveData<NetworkResult<CurrencyResponse>>()
    val exchangeRate: LiveData<NetworkResult<CurrencyResponse>> = _exchangeRate

    fun getLatestExchangeRate() {
        _exchangeRate.value = NetworkResult.Loading()

        viewModelScope.launch {
            try {
                _exchangeRate.value = currencyRepository.getLatestRates("")

            } catch (e: Exception) {
                _exchangeRate.value = NetworkResult.Error("Ошибка загрузки данных: ${e.message}")
            }

        }
    }

}

class VideoListViewModelFactory @Inject constructor(
    private val currencyRepository: CurrencyRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ExchangeRateViewModel(currencyRepository) as T
    }

}