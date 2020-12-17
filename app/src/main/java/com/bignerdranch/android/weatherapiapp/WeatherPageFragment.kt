package com.bignerdranch.android.weatherapiapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bignerdranch.android.weatherapiapp.model.Weather
import com.bignerdranch.android.weatherapiapp.network.WeatherInterface
import com.bignerdranch.android.weatherapiapp.viewmodel.WeatherViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val TAG = "WeatherPageFragment"
private const val BASE_URL = "https://api.weatherapi.com/v1/"
//private const val API_KEY = "-U1bfntUuMZ-vKhJTY-Se2qgA85B5bl22meeTZcL0QP53prEaE3lgO2RW5Rg9cbrl19_pHdhrDkvdmDzm37Nk0U1atjEGWVHXn_1Uk7t1mI5lqb36b_c7ro0gZImXnYx"
private const val API_KEY = "843eaebc6a294b4593b190359201612"
//http://api.weatherapi.com/v1/current.json?key=843eaebc6a294b4593b190359201612&q=40.777272, -74.269483


class WeatherPageFragment : Fragment() {
    private lateinit var  weatherViewModel: WeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_weather_page, container, false)

        weatherViewModel= ViewModelProvider(this).get(WeatherViewModel::class.java)

        //val address = view.findViewById<TextView>(R.id.address)
        weatherViewModel.getCurrentWeather(API_KEY,"40.777272,-74.269483").observe(viewLifecycleOwner,
            Observer {
                Log.i(TAG,"${it.location.country}")
            })

        return view
    }


}