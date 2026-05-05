package com.example.bussmarttracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.bussmarttracker.ui.navigation.AppNavigation
import com.example.bussmarttracker.ui.theme.BusSmartTrackerTheme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BusSmartTrackerTheme {

                val navController = rememberNavController()

                Scaffold {
                    AppNavigation(navController)
                }
            }
        }
    }
}