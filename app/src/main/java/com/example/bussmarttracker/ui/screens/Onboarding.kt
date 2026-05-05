package com.example.bussmarttracker.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bussmarttracker.R
import com.example.bussmarttracker.ui.theme.primaryColor
import com.example.bussmarttracker.ui.theme.secondaryColor
import com.airbnb.lottie.compose.*

@Composable
fun OnboardingScreen(modifier: Modifier = Modifier) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        // Lottie Animation
        LottieAnimationWidget(
            lottiePath = R.raw.bus_login,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Start Your Journey",
            style = TextStyle(
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = primaryColor,
                textAlign = TextAlign.Center
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Track buses in real-time and never miss your ride.",
            style = TextStyle(
                fontSize = 18.sp,
                color = secondaryColor,
                textAlign = TextAlign.Center,
                lineHeight = 26.sp
            )
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { /* navigate to login */ },
            colors = ButtonDefaults.buttonColors(
                containerColor = primaryColor,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(
                text = "Get Started",
                modifier = Modifier.padding(horizontal = 60.dp, vertical = 10.dp)
            )
        }
    }
}

@Composable
fun LottieAnimationWidget(
    lottiePath: Int,
    modifier: Modifier = Modifier
) {
    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(lottiePath)
    )

    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever
    )

    LottieAnimation(
        composition = composition,
        progress = { progress },
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun OnboardingPreview() {
    OnboardingScreen()
}