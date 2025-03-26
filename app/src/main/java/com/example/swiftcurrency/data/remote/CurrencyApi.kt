package com.example.swiftcurrency.data.remote

import com.example.swiftcurrency.core.NetworkResult
import com.example.swiftcurrency.entity.CurrencyResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyApi {

    @GET("latest/")
    suspend fun getLatestRates(
        @Query("base_currency") baseCurrency: String = ""
    ): NetworkResult<CurrencyResponse>
}