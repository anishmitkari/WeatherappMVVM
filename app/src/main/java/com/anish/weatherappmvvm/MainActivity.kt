package com.anish.weatherappmvvm

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.anish.weatherappmvvm.databinding.ActivityMainBinding
import com.anish.weatherappmvvm.viewmodel.WeatherViewmodel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val viewmodel: WeatherViewmodel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewmodel.weatherResp.observe(this, { weather ->

            binding.apply {
                Log.e("TAG>>>>>>>>>>     ", "onCreate: "+weather.temperature )
                binding.tvTemperature.text = weather.temperature
                tvDescription.text = weather.description
                tvWind.text = weather.wind
                val forcast1 = weather.forecast[0]
                val forcast2 = weather.forecast[1]
                val forcast3 = weather.forecast[2]
                tvForecast1.text = "${forcast1.temperature}/${forcast1.wind}"
                tvForecast2.text = "${forcast2.temperature}/${forcast1.wind}"
                tvForecast3.text = "${forcast3.temperature}/${forcast1.wind}"
            }
        })
    }
}