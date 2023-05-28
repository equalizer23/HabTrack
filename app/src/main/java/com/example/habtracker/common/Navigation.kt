package com.example.habtracker.common

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost

import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.habtracker.presentation.quote_of_the_day_screen.components.QuoteOfTheDayScreen
import com.example.habtracker.presentation.signup_screen.SignUpScreen
import com.example.habtracker.presentation.splash_screen.SplashScreen


@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "splash"
    ){
        bottomNavigation(navController)

        composable("splash"){
            SplashScreen(navController)
        }
        composable("quote"){
            QuoteOfTheDayScreen(navController = navController)
        }

        composable("signup"){
            SignUpScreen(navController = navController)
        }
        

    }
}


fun NavGraphBuilder.bottomNavigation(
    navController: NavHostController
) {

}