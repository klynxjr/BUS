package com.example.bussmarttracker.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.SnapPosition.Center.position
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.android.gms.maps.model.*
import com.google.maps.android.compose.*

@Composable
fun DashboardScreen() {

    // Example: Nairobi (you can replace with real GPS later)
    val busLocation = LatLng(-1.2921, 36.8219)

    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(busLocation, 14f)
    }

    Box(modifier = Modifier.fillMaxSize()) {

        // 🗺️ Map
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState
        ) {

            // 🚌 Bus Marker
            Marker(
                state = MarkerState(position = busLocation),
                title = "Bus 101",
                snippet = "On Route"
            )
        }

        // 📊 Bottom Info Panel
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {

                Text(
                    text = "Bus 101",
                    style = MaterialTheme.typography.titleLarge
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text("Route: CBD → Westlands")
                Text("Status: On Time")
                Text("ETA: 8 minutes")

                Spacer(modifier = Modifier.height(12.dp))

                Button(
                    onClick = { /* track details */ },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("View Details")
                }
            }
        }
    }
}