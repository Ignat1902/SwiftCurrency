package com.example.swiftcurrency.di

import com.example.swiftcurrency.presentation.ExchangeRateFragment
import dagger.Component

@Component(modules = [NetworkModule::class])
interface AppComponent {
    fun inject(fragment: ExchangeRateFragment)
}
