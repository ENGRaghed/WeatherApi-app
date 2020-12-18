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
data class Weather (@SerializedName("location") var location: LocationWeather,
                    @SerializedName("current") var current: current)



data class LocationWeather(@SerializedName("name") val name:String="",
                           @SerializedName("region") var region: String="",
                           @SerializedName("country")var country: String="",
                           @SerializedName("lat")var lat: String="",
                           @SerializedName("lon")var lon: String="",
                           @SerializedName("tz_id")var tz_id: String="",
                           @SerializedName("localtime")var localtime: String=""
)

data class current(@SerializedName("last_updated") var last_updated: String,
                   @SerializedName("temp_c") var temp_c: Double,
                   @SerializedName("temp_f") var temp_f: Double,
                   @SerializedName("is_day") var is_day: Int,
                   @SerializedName("wind_mph") var wind_mph: Double,
                   @SerializedName("wind_kph") var wind_kph: Double,
                   @SerializedName("wind_degree") var wind_degree: Double,
                   @SerializedName("wind_dir") var wind_dir: String,
                   @SerializedName("pressure_mb") var pressure_mb: Double,
                   @SerializedName("pressure_in") var pressure_in: Double,
                   @SerializedName("precip_mm") var precip_mm: Double,
                   @SerializedName("precip_in") var precip_in: Double,
                   @SerializedName("humidity") var humidity: Double,
                   @SerializedName("cloud") var cloud: Double,
                   @SerializedName("feelslike_c") var feelslike_c: Double,
                   @SerializedName("feelslike_f") var feelslike_f: Double,
                   @SerializedName("vis_km") var vis_km: Double,
                   @SerializedName("vis_miles") var vis_miles: Double,
                   @SerializedName("uv") var uv: Double,
                   @SerializedName("gust_mph") var gust_mph: Double,
                   @SerializedName("gust_kph") var gust_kph: Double,
                   @SerializedName("condition") var condition: Condition
)

data class Condition(@SerializedName("text") var text: String,@SerializedName("icon") var icon: String)

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
