package com.dairymaster.composeweatherapp.navigation


import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.dairymaster.composeweatherapp.screens.main.*
import com.dairymaster.composeweatherapp.screens.search.*
import com.dairymaster.composeweatherapp.screens.about.*
import com.dairymaster.composeweatherapp.screens.settings.*
import com.dairymaster.composeweatherapp.screens.favorite.*
import com.dairymaster.composeweatherapp.screens.splash.*


@Composable
fun WeatherNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = WeatherScreens.SplashScreen.name) {

        composable(WeatherScreens.SplashScreen.name) {
            SplashScreen(navController)
        }

        //www.google.com/cityname="seattle"
        val route = WeatherScreens.MainScreen.name
        composable("$route/{city}",
            arguments = listOf(
                navArgument(name = "city"){
                    type = NavType.StringType
                })){ navBack ->
            navBack.arguments?.getString("city").let { city ->

                val mainViewModel = hiltViewModel<MainViewModel>()
                MainScreen(navController = navController, mainViewModel,
                    city = city)
            }
        }

        composable(WeatherScreens.AboutScreen.name) {
            AboutScreen(navController)
        }
        composable(WeatherScreens.FavoriteScreen.name) {
            FavoritesScreen(navController)
        }
        composable(WeatherScreens.SearchScreen.name) {
            SearchScreen(navController)
        }
        composable(WeatherScreens.SettingsScreen.name) {
            SettingsScreen(navController)
        }
    }
}
