package com.bignerdranch.android.weatherapiapp.network

import com.bignerdranch.android.weatherapiapp.model.Weather
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


//http://api.weatherapi.com/v1/current.json?key=843eaebc6a294b4593b190359201612&q=40.777272, -74.269483
interface WeatherInterface {
    @GET("current.json?")
    suspend fun getCurrentWeather(@Query("key") authHeader: String,
                          @Query("q") latlon:String) : Weather
}
