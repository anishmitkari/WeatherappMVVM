package com.anish.weatherappmvvm.reposiory

import com.anish.weatherappmvvm.api.Apiservice
import javax.inject.Inject

class WWeatherRepository @Inject constructor(private val apiservice: Apiservice) {
suspend fun getWeather()= apiservice.getWeather()

}