package com.bignerdranch.android.weatherapiapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query


//http://api.weatherapi.com/v1/current.json?key=843eaebc6a294b4593b190359201612&q=40.777272, -74.269483
interface WeatherInterface {
    @GET("current.json?")
    fun getCurrentWeather(@Query("key") authHeader: String,
                          @Query("q") latlon:String) : Call<Weather>
}
/*
    @GET("businesses/search")
    fun searchRestaurants(
        @Header("Authorization") authHeader: String,
//        @Query("term") searchTerm: String,
        @Query("latitude") lat : String,
        @Query("longitude") lon : String) : Call<YelpSearchResult>
 */