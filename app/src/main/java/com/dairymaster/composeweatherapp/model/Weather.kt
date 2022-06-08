package com.dairymaster.composeweatherapp.model

data class Weather(
    val city: City,
    val cnt: Int,
    val cod: String,
    val list: List<Data>,
    val message: Double
)