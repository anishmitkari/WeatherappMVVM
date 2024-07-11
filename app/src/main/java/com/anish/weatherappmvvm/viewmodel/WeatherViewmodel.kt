package com.anish.weatherappmvvm.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anish.weatherappmvvm.models.Weather
import com.anish.weatherappmvvm.reposiory.WWeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewmodel @Inject constructor(private val repository: WWeatherRepository) :
    ViewModel() {

    private val _resp = MutableLiveData<Weather>()
    val weatherResp: LiveData<Weather>
        get() = _resp

    init {
        getWeather()
    }

    fun getWeather() = viewModelScope.launch {
        repository.getWeather().let { response ->
            if (response.isSuccessful) {

                _resp.postValue(response.body())
            } else {
                Log.e("TAG", "getWeather:error ")
            }
        }
    }
}