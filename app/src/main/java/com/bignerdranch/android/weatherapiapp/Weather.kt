package com.bignerdranch.android.weatherapiapp


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
data class Weather (val location: LocationWeather,val current: current)
data class LocationWeather(val name:String,
val region: String,
val country: String,
val lat: String,
val lon: String,
val tz_id: String,
//val localtime_epoch: String,
val localtime: String)

data class current(val last_updated: String,
                   val temp_c: Double,
                   val temp_f: Double,
                   val is_day: Int,
                   val wind_mph: Double,
                   val wind_kph: Double,
                   val wind_degree: Double,
                   val wind_dir: String,
                   val pressure_mb: Double,
                   val pressure_in: Double,
                   val precip_mm: Double,
                   val precip_in: Double,
                   val humidity: Double,
                   val cloud: Double,
                   val feelslike_c: Double,
                   val feelslike_f: Double,
                   val vis_km: Double,
                   val vis_miles: Double,
                   val uv: Double,
                   val gust_mph: Double,
                   val gust_kph: Double,
                   val condition: Condition)

data class Condition( val text: String,
val icon: String)

