package com.anish.weatherappmvvm.api

import com.anish.weatherappmvvm.models.Weather
import retrofit2.Response
import retrofit2.http.GET

interface Apiservice {
    @GET("weather/India")
    suspend fun getWeather():Response<Weather>
}