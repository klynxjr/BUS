package com.example.bussmarttracker.ui.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.example.bussmarttracker.ui.screens.*

@Composable
fun AppNavigation(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = ROUTES.SPLASH
    ) {
        composable(ROUTES.SPLASH) {
            SplashScreen { route ->
                navController.navigate(route) {
                    popUpTo(ROUTES.SPLASH) { inclusive = true }
                    launchSingleTop = true
                }
            }
        }


    }
}