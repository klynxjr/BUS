package com.example.bussmarttracker.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.bussmarttracker.ui.data.SupabaseClient
import com.example.bussmarttracker.ui.navigation.ROUTES
import io.github.jan.supabase.auth.auth
import kotlinx.coroutines.delay
@Composable
fun SplashScreen(onNavigate: (String) -> Unit) {

    LaunchedEffect(Unit) {
        kotlinx.coroutines.delay(1500)
        onNavigate(ROUTES.ONBOARDING)
    }
    val session = SupabaseClient.client.auth.currentSessionOrNull()

    val route = if (session != null) {
        ROUTES.DASHBOARD
    } else {
        ROUTES.ONBOARDING
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("BusSmartTracker")
    }
}