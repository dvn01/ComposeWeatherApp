package com.dairymaster.composeweatherapp.screens.main

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dairymaster.composeweatherapp.data.DataOrException
import com.dairymaster.composeweatherapp.model.Weather
import com.dairymaster.composeweatherapp.model.WeatherObject
import com.dairymaster.composeweatherapp.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: WeatherRepository):
    ViewModel() {

    suspend fun getWeatherData(city: String) : DataOrException<Weather, Boolean, Exception>{
        return repository.getWeather(cityQuery = city, units = "imperial")
    }
}