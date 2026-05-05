package com.example.bussmarttracker.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.*
import androidx.compose.ui.unit.*
import com.example.bussmarttracker.R
import com.example.bussmarttracker.ui.theme.primaryColor
import com.example.bussmarttracker.ui.theme.secondaryColor
import com.airbnb.lottie.compose.*
import com.google.firebase.auth.FirebaseAuth

@Composable
fun ForgotPasswordScreen(modifier: Modifier = Modifier) {

    var emailInput by remember { mutableStateOf(TextFieldValue("")) }
    val auth = remember { FirebaseAuth.getInstance() }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        LottieAnimationWidget(R.raw.bus_login, 300.dp)

        Spacer(modifier = Modifier.height(36.dp))

        Text(
            text = "Oops! Forgot Password?",
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = primaryColor
            )
        )

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = emailInput,
            onValueChange = { emailInput = it },
            label = { Text("Email Address") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Email,
                    contentDescription = "Email Input",
                    tint = primaryColor
                )
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = secondaryColor,
                unfocusedBorderColor = primaryColor
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedButton(
            onClick = {
                auth.sendPasswordResetEmail(emailInput.text)
            },
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Color.White,
                containerColor = primaryColor
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Get Password Reset")
        }

        Row {
            TextButton(onClick = { /* navigate back */ }) {
                Text("Back to login", fontSize = 11.sp)
            }
            TextButton(onClick = { /* go to signup */ }) {
                Text("No account?", fontSize = 11.sp)
            }
        }
    }
}