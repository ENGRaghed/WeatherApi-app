package com.bignerdranch.android.weatherapiapp

import android.app.Application

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        ServiceLocator.init(this)
    }
}