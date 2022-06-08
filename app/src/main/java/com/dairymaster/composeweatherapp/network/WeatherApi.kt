package com.dairymaster.composeweatherapp.network

import com.dairymaster.composeweatherapp.model.Weather
import com.dairymaster.composeweatherapp.model.WeatherObject
import com.dairymaster.composeweatherapp.utils.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface WeatherApi {
    @GET(value = "data/2.5/forecast/daily")
    suspend fun getWeather(@Query("q") query: String,
                           @Query("units") units: String = "imperial",
                           @Query("appid") appId: String = API_KEY): Weather
}