package com.dairymaster.composeweatherapp.repository

import android.util.Log
import com.dairymaster.composeweatherapp.data.DataOrException
import com.dairymaster.composeweatherapp.model.Weather
import com.dairymaster.composeweatherapp.model.WeatherObject
import com.dairymaster.composeweatherapp.network.WeatherApi
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val api: WeatherApi){
    suspend fun getWeather(cityQuery: String, units: String)
            : DataOrException<Weather, Boolean, Exception> {
        val response = try {
            api.getWeather(query = cityQuery, units = units)

        }catch (e: Exception){
            Log.d("WeatherRepository", "getWeather: $e")
            return DataOrException(e = e)
        }
        Log.d("WeatherRepository", "getWeather: $response")
        return  DataOrException(data = response)
    }
}