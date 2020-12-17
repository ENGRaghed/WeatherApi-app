package com.bignerdranch.android.weatherapiapp.network

import com.bignerdranch.android.weatherapiapp.model.Weather
import com.google.gson.annotations.SerializedName

class WeatherResponse {
    @SerializedName("current")
    lateinit var weather: Weather
}