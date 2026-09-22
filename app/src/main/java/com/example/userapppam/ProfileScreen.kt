package com.example.userapppam

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ProfileScreen(navController: NavController) {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var instagram by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var favColor by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
            .padding(bottom = 24.dp)
    ) {
        Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = AppColors.CardBackground),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(24.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "PROFIL",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        color = AppColors.TitleText
                    )
                    Box(
                        modifier = Modifier
                            .size(44.dp)
                            .background(AppColors.AvatarBg, CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Person,
                            contentDescription = "Foto Profil",
                            tint = AppColors.AvatarIcon
                        )
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                ColoredField("First Name", firstName, { firstName = it }, AppColors.FieldFirstName)
                ColoredField("Last Name", lastName, { lastName = it }, AppColors.FieldLastName)
                ColoredField("Username", username, { username = it }, AppColors.FieldUsername)
                ColoredField("Email", email, { email = it }, AppColors.FieldEmail, keyboardType = KeyboardType.Email)
                ColoredField("Password", password, { password = it }, AppColors.FieldPassword, isPassword = true)
                ColoredField("Instagram", instagram, { instagram = it }, AppColors.FieldInstagram)
                ColoredField(
                    "Nomor Telp", phone, { phone = it }, AppColors.FieldPhone,
                    textColor = Color.White, keyboardType = KeyboardType.Phone
                )
                ColoredField("Warna Favorit", favColor, { favColor = it }, AppColors.FieldFavColor)

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        Toast.makeText(context, "Profil berhasil disimpan", Toast.LENGTH_SHORT).show()
                    },
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.buttonColors(containerColor = AppColors.ButtonSave),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .width(140.dp)
                        .height(48.dp)
                ) {
                    Text("SAVE", color = AppColors.ButtonText, fontWeight = FontWeight.Bold)
                }
                Spacer(modifier = Modifier.height(12.dp))

                Button(
                    onClick = { navController.navigate("avatar") },
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.buttonColors(containerColor = AppColors.FieldInstagram),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .width(180.dp)
                        .height(48.dp)
                ) {
                    Text("EDIT AVATAR", color = AppColors.ButtonText, fontWeight = FontWeight.Bold)
                }
                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    onClick = {
                        navController.navigate("login") {
                            popUpTo(0) { inclusive = true }
                        }
                    },
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.buttonColors(containerColor = AppColors.ButtonLogout),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .width(140.dp)
                        .height(48.dp)
                ) {
                    Text("LOGOUT", color = AppColors.ButtonText, fontWeight = FontWeight.Bold)
                }
                Text(
                    text = "INDIRA KALLISTA N_245150407111062",
                    fontSize = 16.sp,
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
}