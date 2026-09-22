package com.example.userapppam

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun LoginScreen(navController: NavController) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var showForgotDialog by remember { mutableStateOf(false) }
    var forgotEmail by remember { mutableStateOf("") }
    val context = LocalContext.current

    Box(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = AppColors.CardBackground),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "LOGIN",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = AppColors.TitleText
                )
                Spacer(modifier = Modifier.height(40.dp))

                ColoredField("Username", username, { username = it }, AppColors.FieldUsername)

                Text(
                    text = "Password",
                    fontSize = 13.sp,
                    fontStyle = FontStyle.Italic,
                    color = AppColors.LabelText,
                    modifier = Modifier.fillMaxWidth().padding(top = 10.dp, bottom = 4.dp)
                )

                // ---- Field password dengan blinded text + toggle mata ----
                TextField(
                    value = password,
                    onValueChange = { password = it },
                    singleLine = true,
                    shape = RoundedCornerShape(50),
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    trailingIcon = {
                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            Icon(
                                imageVector = if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                                contentDescription = "Toggle Password"
                            )
                        }
                    },
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = AppColors.FieldPassword,
                        unfocusedContainerColor = AppColors.FieldPassword,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    modifier = Modifier.fillMaxWidth().height(52.dp)
                )

                // ---- Lupa Password ----
                Text(
                    text = "Lupa Password?",
                    color = AppColors.LinkText,
                    fontSize = 12.sp,
                    fontStyle = FontStyle.Italic,
                    textAlign = TextAlign.End,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp)
                        .clickable { showForgotDialog = true }
                )

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = {
                        if (username.isNotBlank() && password.isNotBlank()) {
                            Toast.makeText(context, "Login berhasil, selamat datang $username!", Toast.LENGTH_SHORT).show()
                            navController.navigate("profile") { popUpTo("login") { inclusive = true }
                            }
                        } else {
                            Toast.makeText(context, "Username dan Password wajib diisi", Toast.LENGTH_SHORT).show()
                        }
                    },
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.buttonColors(containerColor = AppColors.ButtonLogin),
                    modifier = Modifier.width(140.dp).height(48.dp)
                ) {
                    Text("LOGIN", color = AppColors.ButtonText, fontWeight = FontWeight.Bold)
                }
                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Belum punya akun? Register",
                    color = AppColors.LinkText,
                    fontSize = 13.sp,
                    modifier = Modifier.clickable { navController.navigate("register") }
                )
                Text(
                    text = "INDIRA KALLISTA N_245150407111062",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    color = AppColors.TitleText,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 15.dp)
                )
            }
        }
    }

    // ---- Dialog Lupa Password ----
    if (showForgotDialog) {
        AlertDialog(
            onDismissRequest = { showForgotDialog = false },
            title = { Text("Lupa Password") },
            text = {
                Column {
                    Text("Masukkan email kamu, kami akan kirim link untuk reset password.")
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(
                        value = forgotEmail,
                        onValueChange = { forgotEmail = it },
                        placeholder = { Text("Masukkan email terdaftar") },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                    )
                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = "Belum punya akun? Register",
                        color = AppColors.LinkText,
                        fontSize = 13.sp,
                        modifier = Modifier.clickable { navController.navigate("register") }
                    )
                }
            },
            confirmButton = {
                TextButton(onClick = {
                    if (forgotEmail.isNotBlank()) {
                        Toast.makeText(context, "Link reset password dikirim ke $forgotEmail", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(context, "Email tidak boleh kosong", Toast.LENGTH_SHORT).show()
                    }
                    showForgotDialog = false
                }) { Text("Kirim") }
            },
            dismissButton = {
                TextButton(onClick = { showForgotDialog = false }) { Text("Batal") }
            }
        )
    }
}
