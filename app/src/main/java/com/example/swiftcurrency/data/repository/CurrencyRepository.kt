package com.example.swiftcurrency.data.repository

import com.example.swiftcurrency.core.NetworkResult
import com.example.swiftcurrency.data.remote.CurrencyApi
import com.example.swiftcurrency.entity.CurrencyResponse
import javax.inject.Inject

class CurrencyRepository @Inject constructor(private val remoteDataSource: CurrencyApi) {
    suspend fun getLatestRates(baseCurrency: String): NetworkResult<CurrencyResponse> =
        remoteDataSource.getLatestRates(baseCurrency)
}