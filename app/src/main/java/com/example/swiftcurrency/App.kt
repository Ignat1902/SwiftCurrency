package com.example.swiftcurrency

import android.app.Application
import android.content.Context
import android.util.Log
import com.example.swiftcurrency.di.AppComponent
import com.example.swiftcurrency.di.DaggerAppComponent

class App : Application() {

    private var _appComponent: AppComponent? = null

    internal val appComponent: AppComponent
        get() {
            Log.d("AP", "Getting appComponent")
            return checkNotNull(_appComponent) {
                "AppComponent isn't initialized"
            }
        }

    override fun onCreate() {
        super.onCreate()
        Log.d("AP", "Initializing appComponent")
        _appComponent = DaggerAppComponent.create()
    }
}

/*
val Context.appComponent: AppComponent
    get() = when (this) {
        is App -> appComponent
        else -> applicationContext.appComponent
    }
*/

