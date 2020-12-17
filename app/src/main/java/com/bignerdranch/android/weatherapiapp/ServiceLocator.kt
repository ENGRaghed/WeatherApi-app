package com.bignerdranch.android.weatherapiapp

import android.content.Context
import com.bignerdranch.android.weatherapiapp.network.WeatherInterface
import com.bignerdranch.android.weatherapiapp.repositry.WeatherRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceLocator {


    private lateinit var app: App
    lateinit var retrofit: Retrofit
    lateinit var weatherApi: WeatherInterface

    fun init(app: App) {
        this.app = app
        initializeNetwork(app)
    }


    private fun initializeNetwork(context: Context) {
        retrofit = Retrofit.Builder()
            .baseUrl("https://api.weatherapi.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        weatherApi = retrofit.create(WeatherInterface::class.java)
    }

    val weatherRepository: WeatherRepository by lazy {
        WeatherRepository(weatherApi)
    }



}