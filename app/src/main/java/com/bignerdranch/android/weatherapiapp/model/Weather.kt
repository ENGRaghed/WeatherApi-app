package com.bignerdranch.android.weatherapiapp.model

import com.google.gson.annotations.SerializedName


/*
{
    "location": {
        "name": "Saint Cloud",
        "region": "New Jersey",
        "country": "United States of America",
        "lat": 40.78,
        "lon": -74.27,
        "tz_id": "America/New_York",
        "localtime_epoch": 1608219521,
        "localtime": "2020-12-17 10:38"
    },
    "current": {
        "last_updated_epoch": 1608219023,
        "last_updated": "2020-12-17 10:30",
        "temp_c": -1.1,
        "temp_f": 30.0,
        "is_day": 1,
        "condition": {
            "text": "Overcast",
            "icon": "//cdn.weatherapi.com/weather/64x64/day/122.png",
            "code": 1009
        },
        "wind_mph": 6.9,
        "wind_kph": 11.2,
        "wind_degree": 30,
        "wind_dir": "NNE",
        "pressure_mb": 1013.0,
        "pressure_in": 30.4,
        "precip_mm": 5.7,
        "precip_in": 0.22,
        "humidity": 71,
        "cloud": 100,
        "feelslike_c": -8.2,
        "feelslike_f": 17.3,
        "vis_km": 11.0,
        "vis_miles": 6.0,
        "uv": 1.0,
        "gust_mph": 32.2,
        "gust_kph": 51.8
    }
}
 */
data class Weather (var location: LocationWeather, var current: current)



data class LocationWeather(val name:String="",
var region: String="",
var country: String="",
var lat: String="",
var lon: String="",
var tz_id: String="",
var localtime: String=""
)

data class current(var last_updated: String,
                   var temp_c: Double,
                   var temp_f: Double,
                   var is_day: Int,
                   var wind_mph: Double,
                   var wind_kph: Double,
                   var wind_degree: Double,
                   var wind_dir: String,
                   var pressure_mb: Double,
                   var pressure_in: Double,
                   var precip_mm: Double,
                   var precip_in: Double,
                   var humidity: Double,
                   var cloud: Double,
                   var feelslike_c: Double,
                   var feelslike_f: Double,
                   var vis_km: Double,
                   var vis_miles: Double,
                   var uv: Double,
                   var gust_mph: Double,
                   var gust_kph: Double,
                   var condition: Condition
)

data class Condition( var text: String, var icon: String)

//
//data class Weather(
//    var is_day: Int,
//    var wind_mph: Double,
//    var wind_kph: Double,
//    var wind_degree: Double,
//    var wind_dir: String,
//    var pressure_mb: Double,
//    var pressure_in: Double,
//    var precip_mm: Double,
//    var precip_in: Double,
//    var humidity: Double,
//    var cloud: Double,
//    var feelslike_c: Double,
//    var feelslike_f: Double,
//    var vis_km: Double,
//    var vis_miles: Double,
//    var uv: Double,
//    var gust_mph: Double,
//    var gust_kph: Double,
//    val temp_c: Double,
//    val temp_f: Double,
//    val condition: WeatherCondition)
//data class WeatherCondition(
//    val text: String,
//    val icon: String)
