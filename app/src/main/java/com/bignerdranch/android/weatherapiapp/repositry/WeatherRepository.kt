package com.bignerdranch.android.weatherapiapp.repositry

import com.bignerdranch.android.weatherapiapp.model.Weather
//import com.bignerdranch.android.weatherapiapp.model.current
import com.bignerdranch.android.weatherapiapp.network.WeatherInterface

private const val TAG = "WeatherFetchr"

class WeatherRepository ( private val weatherApi: WeatherInterface ){

        suspend fun getWeather(key: String,latlon : String,days : String): Weather {
        return weatherApi.getCurrentWeather(key,latlon,days)
    }
}