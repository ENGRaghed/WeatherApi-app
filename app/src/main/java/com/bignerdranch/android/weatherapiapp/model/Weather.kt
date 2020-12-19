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
//data class Weather (@SerializedName("location") var location: LocationWeather,
//                    @SerializedName("current") var current: current)


//
//data class LocationWeather(@SerializedName("name") val name:String="",
//                           @SerializedName("region") var region: String="",
//                           @SerializedName("country")var country: String="",
//                           @SerializedName("lat")var lat: String="",
//                           @SerializedName("lon")var lon: String="",
//                           @SerializedName("tz_id")var tz_id: String="",
//                           @SerializedName("localtime")var localtime: String=""
//)
//
//data class current(@SerializedName("last_updated") var last_updated: String,
//                   @SerializedName("temp_c") var temp_c: Double,
//                   @SerializedName("temp_f") var temp_f: Double,
//                   @SerializedName("is_day") var is_day: Int,
//                   @SerializedName("wind_mph") var wind_mph: Double,
//                   @SerializedName("wind_kph") var wind_kph: Double,
//                   @SerializedName("wind_degree") var wind_degree: Double,
//                   @SerializedName("wind_dir") var wind_dir: String,
//                   @SerializedName("pressure_mb") var pressure_mb: Double,
//                   @SerializedName("pressure_in") var pressure_in: Double,
//                   @SerializedName("precip_mm") var precip_mm: Double,
//                   @SerializedName("precip_in") var precip_in: Double,
//                   @SerializedName("humidity") var humidity: Double,
//                   @SerializedName("cloud") var cloud: Double,
//                   @SerializedName("feelslike_c") var feelslike_c: Double,
//                   @SerializedName("feelslike_f") var feelslike_f: Double,
//                   @SerializedName("vis_km") var vis_km: Double,
//                   @SerializedName("vis_miles") var vis_miles: Double,
//                   @SerializedName("uv") var uv: Double,
//                   @SerializedName("gust_mph") var gust_mph: Double,
//                   @SerializedName("gust_kph") var gust_kph: Double,
//                   @SerializedName("condition") var condition: Condition
//)
//
//data class Condition(@SerializedName("text") var text: String,@SerializedName("icon") var icon: String)

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

data class Weather(
    val alert: Alert,
    val current: Current,
    val forecast: Forecast,
    val location: Location
) {
    class Alert(
    )

    data class Current(
        val cloud: Int,
        val condition: Condition,
        val feelslike_c: Double,
        val feelslike_f: Double,
        val gust_kph: Double,
        val gust_mph: Double,
        val humidity: Int,
        val is_day: Int,
        val last_updated: String,
        val last_updated_epoch: Int,
        val precip_in: Double,
        val precip_mm: Double,
        val pressure_in: Double,
        val pressure_mb: Double,
        val temp_c: Double,
        val temp_f: Double,
        val uv: Double,
        val vis_km: Double,
        val vis_miles: Double,
        val wind_degree: Int,
        val wind_dir: String,
        val wind_kph: Double,
        val wind_mph: Double
    ) {
        data class Condition(
            val code: Int,
            val icon: String,
            val text: String
        )
    }

    data class Forecast(
        val forecastday: List<Forecastday>
    ) {
        data class Forecastday(
            val astro: Astro,
            val date: String,
            val date_epoch: Int,
            val day: Day,
            val hour: List<Hour>
        ) {
            data class Astro(
                val moon_illumination: String,
                val moon_phase: String,
                val moonrise: String,
                val moonset: String,
                val sunrise: String,
                val sunset: String
            )

            data class Day(
                val avghumidity: Double,
                val avgtemp_c: Double,
                val avgtemp_f: Double,
                val avgvis_km: Double,
                val avgvis_miles: Double,
                val condition: Condition,
                val daily_chance_of_rain: String,
                val daily_chance_of_snow: String,
                val daily_will_it_rain: Int,
                val daily_will_it_snow: Int,
                val maxtemp_c: Double,
                val maxtemp_f: Double,
                val maxwind_kph: Double,
                val maxwind_mph: Double,
                val mintemp_c: Double,
                val mintemp_f: Double,
                val totalprecip_in: Double,
                val totalprecip_mm: Double,
                val uv: Double
            ) {
                data class Condition(
                    val code: Int,
                    val icon: String,
                    val text: String
                )
            }

            data class Hour(
                val chance_of_rain: String,
                val chance_of_snow: String,
                val cloud: Int,
                val condition: Condition,
                val dewpoint_c: Double,
                val dewpoint_f: Double,
                val feelslike_c: Double,
                val feelslike_f: Double,
                val gust_kph: Double,
                val gust_mph: Double,
                val heatindex_c: Double,
                val heatindex_f: Double,
                val humidity: Int,
                val is_day: Int,
                val precip_in: Double,
                val precip_mm: Double,
                val pressure_in: Double,
                val pressure_mb: Double,
                val temp_c: Double,
                val temp_f: Double,
                val time: String,
                val time_epoch: Int,
                val vis_km: Double,
                val vis_miles: Double,
                val will_it_rain: Int,
                val will_it_snow: Int,
                val wind_degree: Int,
                val wind_dir: String,
                val wind_kph: Double,
                val wind_mph: Double,
                val windchill_c: Double,
                val windchill_f: Double
            ) {
                data class Condition(
                    val code: Int,
                    val icon: String,
                    val text: String
                )
            }
        }
    }

    data class Location(
        val country: String,
        val lat: Double,
        val localtime: String,
        val localtime_epoch: Int,
        val lon: Double,
        val name: String,
        val region: String,
        val tz_id: String
    )
}
