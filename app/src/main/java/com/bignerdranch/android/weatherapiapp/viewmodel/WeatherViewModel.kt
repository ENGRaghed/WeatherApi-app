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

    fun getCurrentWeather(key : String,latlon : String,days:String):LiveData<Weather>{
        val weather = MutableLiveData<Weather>()
        viewModelScope.launch {
            weather.value = weatherRepository.getWeather(key,latlon,days)
        }
        return weather
    }

}