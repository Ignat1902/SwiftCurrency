package com.example.swiftcurrency.entity

import com.google.gson.annotations.SerializedName

data class CurrencyResponse(
    @SerializedName("data")
    val data: Map<String, Float>
)
