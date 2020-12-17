package com.bignerdranch.android.weatherapiapp.repositry

import com.bignerdranch.android.weatherapiapp.model.Weather
import com.bignerdranch.android.weatherapiapp.network.WeatherInterface

private const val TAG = "WeatherFetchr"

class WeatherRepository ( private val weatherApi: WeatherInterface ){

    suspend fun getWeather(key: String,latlon : String): Weather {
//        return flickrApi.searchByLocationPhotosWithDomain(lat, lon, radius).photos.photos
        return weatherApi.getCurrentWeather(key,latlon).weather
    }


}