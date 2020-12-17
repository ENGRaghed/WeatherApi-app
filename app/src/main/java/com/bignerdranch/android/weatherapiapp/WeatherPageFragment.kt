package com.bignerdranch.android.weatherapiapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
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
    lateinit var weather: Weather
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_weather_page, container, false)


        /*
                val restaurants = mutableListOf<YelpRestaurant>()
        val adapter = RestaurantsAdapter(this, restaurants)
        rvRestaurants.adapter = adapter
        rvRestaurants.layoutManager = LinearLayoutManager(this)

        val retrofit =
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build()
        val yelpService = retrofit.create(YelpService::class.java)
        //"Avocado Toast"
        yelpService.searchRestaurants("Bearer $API_KEY", "40.814564", "-74.220654").enqueue(object : Callback<YelpSearchResult> {
            override fun onResponse(call: Call<YelpSearchResult>, response: Response<YelpSearchResult>) {
                Log.i(TAG, "onResponse $response")
                val body = response.body()
                if (body == null) {
                    Log.w(TAG, "Did not receive valid response body from Yelp API... exiting")
                    return
                }
                restaurants.addAll(body.restaurants)
                adapter.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<YelpSearchResult>, t: Throwable) {
                Log.i(TAG, "onFailure $t")
            }
        })
         */
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




        return view
    }


}