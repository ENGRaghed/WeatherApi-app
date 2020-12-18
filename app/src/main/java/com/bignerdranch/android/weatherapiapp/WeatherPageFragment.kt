package com.bignerdranch.android.weatherapiapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bignerdranch.android.weatherapiapp.model.LocationWeather
import com.bignerdranch.android.weatherapiapp.model.current
import com.bignerdranch.android.weatherapiapp.viewmodel.WeatherViewModel

private const val TAG = "WeatherPageFragment"
private const val BASE_URL = "https://api.weatherapi.com/v1/"
private const val API_KEY = "843eaebc6a294b4593b190359201612"
//http://api.weatherapi.com/v1/current.json?key=843eaebc6a294b4593b190359201612&q=40.777272, -74.269483


class WeatherPageFragment : Fragment() {
    private lateinit var  weatherViewModel: WeatherViewModel
    private  var current: current? = null
    private  var locationWeather: LocationWeather = LocationWeather()


    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_weather_page, container, false)


        weatherViewModel= ViewModelProvider(this).get(WeatherViewModel::class.java)

        val address_tv = view.findViewById<TextView>(R.id.address)
        val status_tv = view.findViewById<TextView>(R.id.status)
        val updatedAt_tv = view.findViewById<TextView>(R.id.updated_at)
        val temp_tv = view.findViewById<TextView>(R.id.temp)
        val temp_max_tv= view.findViewById<TextView>(R.id.temp_max)
        val temp_min_tv = view.findViewById<TextView>(R.id.temp_min)


        weatherViewModel.getCurrentWeather(API_KEY,"40.777272,-74.269483").observe(viewLifecycleOwner,
            Observer {
//                Log.i(TAG,"${it.condition.text}, name : ${it.name}")
                Log.i(TAG,"${it.condition.text}")
//                current = it
                setCurrent(it)
                status_tv.text = it.condition.text
                updatedAt_tv.text = it.last_updated
                temp_tv.text = "${it.temp_c}°C"
//                temp_max_tv.text = "Max Temp:$"

            })

        weatherViewModel.getCurrentWeatherLocation(API_KEY,"40.777272,-74.269483").observe(viewLifecycleOwner,
            Observer {
                Log.i(TAG,"${it.country}")
//                locationWeather  =
                address_tv.text = it.country



                setLocation(it)
            })







        Log.i(TAG,"current out Oberver ${current?.condition?.text}")
        Log.i(TAG,"locationWeather out Oberver ${locationWeather.country}")




        return view
    }
/*
 val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
        val weatherInterface = retrofit.create(WeatherInterface::class.java)
        weatherInterface.getCurrentWeather(API_KEY,"40.777272,-74.269483").enqueue(object : Callback<Weather>{
            override fun onFailure(call: Call<Weather>, t: Throwable) {
                Log.i(TAG, "onFailure $t")
            }

            override fun onResponse(call: Call<Weather>, response: Response<Weather>) {
                Log.i(TAG, "onResponse $response")
                val body = response.body()
                weather = response.body()!!

                val address = view.findViewById<TextView>(R.id.address)
                address.text = weather.location.country.toString()
                if (body == null) {
                    Log.w(TAG, "Did not receive valid response body from Weather API... exiting")
                    return
                }
            }

        })
 */


    fun setCurrent(current: current){
        this.current = current
    }
    fun setLocation(location: LocationWeather){
        this.locationWeather = location
    }
}