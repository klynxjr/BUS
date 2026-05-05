package com.example.bussmarttracker.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.bussmarttracker.ui.navigation.ROUTES
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.delay
@Composable
fun SplashScreen(onNavigate: (String) -> Unit) {

    val auth = remember { FirebaseAuth.getInstance() }

    LaunchedEffect(Unit) {
        delay(2000)

        if (auth.currentUser != null) {
            onNavigate(ROUTES.DASHBOARD)
        } else {
            onNavigate(ROUTES.ONBOARDING)
        }
    }

    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("BusSmartTracker")
    }
}