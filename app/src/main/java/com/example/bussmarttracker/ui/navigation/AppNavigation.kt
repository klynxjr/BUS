package com.example.bussmarttracker.ui.navigation

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
                }
            }
        }

        composable(ROUTES.ONBOARDING) {
            OnboardingScreen {
                navController.navigate(ROUTES.LOGIN)
            }
        }

        composable(ROUTES.LOGIN) {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(ROUTES.DASHBOARD) {
                        popUpTo(ROUTES.LOGIN) { inclusive = true }
                    }
                },
                onGoToSignup = {
                    navController.navigate(ROUTES.SIGNUP)
                }
            )
        }

        composable(ROUTES.SIGNUP) {
            SignupScreen(
                onSignupSuccess = {
                    navController.navigate(ROUTES.DASHBOARD)
                }
            )
        }

        composable(ROUTES.FORGOT) {
            ForgotPasswordScreen(
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        composable(ROUTES.DASHBOARD) {
            DashboardScreen()
        }
    }
}