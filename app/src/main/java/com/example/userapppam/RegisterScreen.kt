package com.example.userapppam


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun RegisterScreen(navController: NavController) {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var instagram by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var favColor by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = AppColors.CardBackground),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(24.dp)) {

                Text(
                    text = "REGISTER",
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    color = AppColors.TitleText,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )

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
                    onClick = { navController.navigate("profile") },
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

                Text(
                    text = "Sudah punya akun? Login",
                    color = AppColors.LinkText,
                    fontSize = 13.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { navController.navigate("login") }
                )
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