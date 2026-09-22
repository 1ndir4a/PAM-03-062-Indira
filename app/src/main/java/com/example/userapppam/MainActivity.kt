package com.example.userapppam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .systemBarsPadding()
                        .navigationBarsPadding()
                ) {
                    Box(modifier = Modifier.fillMaxSize()) {

                        // ---- Layer background ----
                        Image(
                            painter = painterResource(id = R.drawable.bg_pattern),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )

                        // ---- Layer konten (Register/Login/Profil) ----
                        val navController = rememberNavController()
                        NavHost(navController = navController, startDestination = "register") {
                            composable("register") { RegisterScreen(navController) }
                            composable("login") { LoginScreen(navController) }
                            composable("profile") { ProfileScreen(navController) }
                            composable("avatar") { AvatarScreen(navController,) }
                        }
                    }
                }
            }
        }
    }
}