package com.bignerdranch.android.weatherapiapp.repositry

import com.bignerdranch.android.weatherapiapp.model.LocationWeather
import com.bignerdranch.android.weatherapiapp.model.Weather
import com.bignerdranch.android.weatherapiapp.model.current
import com.bignerdranch.android.weatherapiapp.network.WeatherInterface

private const val TAG = "WeatherFetchr"

class WeatherRepository ( private val weatherApi: WeatherInterface ){

    suspend fun getWeather(key: String,latlon : String): current {
//        return flickrApi.searchByLocationPhotosWithDomain(lat, lon, radius).photos.photos
        return weatherApi.getCurrentWeather(key,latlon).current
    }

    suspend fun getWeatherLocation(key: String,latlon : String): LocationWeather {
//        return flickrApi.searchByLocationPhotosWithDomain(lat, lon, radius).photos.photos
        return weatherApi.getCurrentWeather(key,latlon).location
    }


}