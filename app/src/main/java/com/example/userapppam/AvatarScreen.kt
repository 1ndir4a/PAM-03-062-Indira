package com.example.userapppam

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun AvatarScreen(navController: NavController) {
    // State untuk tiap komponen wajah, defaultnya semua tampil (checked)
    var showBrow by remember { mutableStateOf(true) }
    var showEye by remember { mutableStateOf(true) }
    var showNose by remember { mutableStateOf(true) }
    var showMouth by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier.fillMaxSize()
            .background(AppColors.Background)

    ) {
        Text(
            text = "CUSTOM YOUR AVATAR!",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = AppColors.TitleText,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentAlignment = Alignment.Center
        )
        {
            val faceWidthPx = 911f
            val faceHeightPx = 1293f

            val faceDisplayWidth = 240.dp
            val faceDisplayHeight =
                faceDisplayWidth *
                        (faceHeightPx / faceWidthPx)
            Box(
                modifier = Modifier.size(
                    width = faceDisplayWidth,
                    height = faceDisplayHeight
                ),
                contentAlignment = Alignment.Center
            ) {

                // =========================
                // WAJAH
                // =========================
                Image(
                    painter = painterResource(
                        id = R.drawable.face_0004
                    ),
                    contentDescription = "Wajah dasar",
                    modifier = Modifier
                        .matchParentSize()
                        .offset(y = (-20).dp)
                )
                // =========================
                // ALIS
                // =========================
                if (showBrow) {
                    Image(
                        painter = painterResource(
                            id = R.drawable.face_0001
                        ),
                        contentDescription = "Alis",
                        modifier = Modifier
                            .size(
                                width = faceDisplayWidth *
                                        (597f / faceWidthPx),
                                height = faceDisplayWidth *
                                        (59f / faceWidthPx)
                            )
                            .offset(y = (-55).dp)
                    )
                }

                // =========================
                // MATA
                // =========================
                if (showEye) {
                    Image(
                        painter = painterResource(
                            id = R.drawable.face_0003
                        ),
                        contentDescription = "Mata",
                        modifier = Modifier
                            .size(
                                width = faceDisplayWidth *
                                        (601f / faceWidthPx),
                                height = faceDisplayWidth *
                                        (174f / faceWidthPx)
                            )
                            .offset(x = -1.dp, y = (-30).dp)
                    )
                }


                // =========================
                // HIDUNG
                // =========================
                if (showNose) {
                    Image(
                        painter = painterResource(
                            id = R.drawable.face_0002
                        ),
                        contentDescription = "Hidung",
                        modifier = Modifier
                            .size(
                                width = faceDisplayWidth *
                                        (181f / faceWidthPx),
                                height = faceDisplayWidth *
                                        (125f / faceWidthPx)
                            )
                            .offset(y = 0.dp)
                    )
                }
                // =========================
                // MULUT
                // =========================
                if (showMouth) {
                    Image(
                        painter = painterResource(
                            id = R.drawable.face_0000
                        ),
                        contentDescription = "Mulut",
                        modifier = Modifier
                            .size(
                                width = faceDisplayWidth *
                                        (237f / faceWidthPx),
                                height = faceDisplayWidth *
                                        (137f / faceWidthPx)
                            )
                            .offset(y = 40.dp)
                    )
                }
            }
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
        // ---- Baris checkbox ----
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            CheckboxWithLabel("Brow", showBrow) { showBrow = it }
            CheckboxWithLabel("Eye", showEye) { showEye = it }
            CheckboxWithLabel("Nose", showNose) { showNose = it }
            CheckboxWithLabel("Mouth", showMouth) { showMouth = it }
        }
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
    }
}

@Composable
private fun CheckboxWithLabel(label: String, checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange,
            colors = CheckboxDefaults.colors(checkedColor = AppColors.ButtonSave)
        )
        Text(text = label, fontSize = 16.sp, color = AppColors.LabelText)
    }
}