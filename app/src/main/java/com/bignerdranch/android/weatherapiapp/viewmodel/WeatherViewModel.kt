package com.bignerdranch.android.weatherapiapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bignerdranch.android.weatherapiapp.ServiceLocator
import com.bignerdranch.android.weatherapiapp.model.Weather
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel(){

    var weatherRepository = ServiceLocator.weatherRepository
//    var weather = MutableLiveData<Weather>()
//    fun getCurrentWeather(key: String,latLon: String): LiveData<Weather> {
//        viewModelScope.launch{
//            weather.value = weatherRepository.getWeather(key, latLon)
//        }
//        return weather
//    }


    fun getCurrentWeather(key : String,latlon : String):LiveData<Weather>{
        val weather = MutableLiveData<Weather>()
        viewModelScope.launch {
            weather.value = weatherRepository.getWeather(key,latlon)
        }
        return weather
    }


//    fun getCurrentWeather(key : String,latlon : String):LiveData<current>{
//        val current = MutableLiveData<current>()
//        viewModelScope.launch {
//            current.value = weatherRepository.getWeather(key,latlon)
//        }
//        return current
//    }
//
//    fun getCurrentWeatherLocation(key : String,latlon : String):LiveData<LocationWeather>{
//        var location = MutableLiveData<LocationWeather>()
//        viewModelScope.launch {
//            location.value = weatherRepository.getWeatherLocation(key,latlon)
//        }
//        return location
//    }

}