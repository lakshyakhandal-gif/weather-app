package com.demo.weatherapp

import com.google.gson.annotations.SerializedName

// Renamed the class to 'WeatherResponse' for clarity and convention.
// This is the main class representing the entire API response.
data class WeatherResponse(
    val base: String,
    val clouds: Clouds,
    val cod: Int,
    val coord: Coord,
    val dt: Int,
    val id: Int,
    val main: Main,
    val name: String,
    val sys: Sys,
    val timezone: Int,
    val visibility: Int,
    val weather: List<Weather>,
    val wind: Wind
)

// --- All nested data classes are defined below, in this SAME file ---

data class Clouds(
    val all: Int
)

data class Coord(
    val lat: Double,
    val lon: Double
)

data class Main(
    val temp: Double,
    val humidity: Int,
    val pressure: Int,

    // Use @SerializedName to map JSON snake_case to Kotlin camelCase
    @SerializedName("feels_like") val feelsLike: Double,
    @SerializedName("temp_min") val tempMin: Double,
    @SerializedName("temp_max") val tempMax: Double,
    @SerializedName("sea_level") val seaLevel: Int,
    @SerializedName("grnd_level") val groundLevel: Int
)

data class Sys(
    val type: Int,
    val id: Int,
    val country: String,
    // Use Long for timestamps to prevent potential data overflow
    val sunrise: Long,
    val sunset: Long
)

data class Weather(
    val id: Int,
    val description: String,
    val icon: String,
    // Use @SerializedName to map the "main" JSON field to a unique property name
    @SerializedName("main") val mainCondition: String
)

data class Wind(
    val speed: Double,
    val deg: Int,
    // Gust is sometimes missing from the API response, so make it nullable
    val gust: Double? = null
)
