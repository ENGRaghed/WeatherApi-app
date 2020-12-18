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
import androidx.navigation.fragment.navArgs
import com.bignerdranch.android.weatherapiapp.model.LocationWeather
import com.bignerdranch.android.weatherapiapp.model.current
import com.bignerdranch.android.weatherapiapp.viewmodel.WeatherViewModel

private const val TAG = "WeatherPageFragment"
private const val BASE_URL = "https://api.weatherapi.com/v1/"
private const val API_KEY = "843eaebc6a294b4593b190359201612"


class WeatherPageFragment : Fragment() {
    private lateinit var  weatherViewModel: WeatherViewModel
    private  var current: current? = null
    private  var locationWeather: LocationWeather = LocationWeather()
    private val args  by navArgs<WeatherPageFragmentArgs>()


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

//"40.777272,-74.269483"
        weatherViewModel.getCurrentWeather(API_KEY,args.location)
                .observe(viewLifecycleOwner, Observer {
                    Log.i(TAG,"${it}")
                    status_tv.text = it.current.condition.text
                    updatedAt_tv.text = it.current.last_updated
                    temp_tv.text = "${it.current.temp_c}°C"
                    address_tv.text = it.location.country

                })


        return view
    }

    fun setCurrent(current: current){
        this.current = current
    }
    fun setLocation(location: LocationWeather){
        this.locationWeather = location
    }
}