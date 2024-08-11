package com.loc.newsapp.view.nvgraph

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraph
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.loc.newsapp.view.onboarding.OnBoardingScreen
import com.loc.newsapp.view.onboarding.OnBoardingViewModel

@Composable
fun NavGraph(
    startDestination : String
) {

    val navController = rememberNavController()

    NavHost(navController = navController,  startDestination = startDestination){
        navigation(
            startDestination = Route.OnBoardingScreen.route,
            route = Route.AppStartNavigation.route
        ){
            composable(
                route = Route.OnBoardingScreen.route
            ){
                val viewModel : OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(
                    event = {
                        viewModel.onEvent(it)
                    }
                )
            }
        }

        navigation(
            route = Route.NewsNavigation.route,
            startDestination = Route.NewsNavigatorScreen.route
        ){
            composable(
                route = Route.NewsNavigatorScreen.route
            ){
                Text(text ="News Navigator Screenf")
            }
        }
    }




}
