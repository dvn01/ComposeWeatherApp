package com.dairymaster.composeweatherapp.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dairymaster.composeweatherapp.screens.*
import com.dairymaster.composeweatherapp.screens.main.MainViewModel
import com.dairymaster.composeweatherapp.screens.main.WeatherMainScreen

@Composable
fun WeatherNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = WeatherScreens.SplashScreen.name) {

        composable(WeatherScreens.SplashScreen.name) {
            WeatherSplashScreen(navController)
        }
        composable(WeatherScreens.MainScreen.name) {

            val mainViewModel = hiltViewModel<MainViewModel>()
            WeatherMainScreen(navController, mainViewModel)
        }
        composable(WeatherScreens.AboutScreen.name) {
            WeatherAboutScreen(navController)
        }
        composable(WeatherScreens.FavoriteScreen.name) {
            WeatherFavoriteScreen(navController)
        }
        composable(WeatherScreens.SearchScreen.name) {
            WeatherSearchScreen(navController)
        }
        composable(WeatherScreens.SettingsScreen.name) {
            WeatherSettingsScreen(navController)
        }
    }
}
