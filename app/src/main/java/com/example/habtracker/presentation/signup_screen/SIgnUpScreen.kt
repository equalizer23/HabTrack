package com.example.habtracker.presentation.signup_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.habtracker.R

@Composable
fun SignUpScreen(
    navController: NavHostController
) {
    var username by remember{ mutableStateOf(TextFieldValue("")) }
    var email by remember{ mutableStateOf(TextFieldValue("")) }
    var password by remember{ mutableStateOf(TextFieldValue("")) }
    var showPassword by remember{ mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 40.dp, horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Sign Up to HabTrack",
            color = MaterialTheme.colors.secondary,
            fontSize = 50.sp,
            fontFamily = FontFamily(Font(R.font.notosans_regular)),
            textAlign = TextAlign.Center
        )
        
        OutlinedButton(
            onClick = { /*TODO*/ },
            
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.google_logo),
                    contentDescription = "Google Logo"
                )
            }
            
        }

        OutlinedTextField(
            value = username,
            modifier = Modifier.background(color = MaterialTheme.colors.background),
            onValueChange = {
                username = it
            },
            label = {
                Text(
                    text = "What is your username?",
                    color = MaterialTheme.colors.secondary
                )
            },
            placeholder = {
                Text(
                    text = "Enter your username",
                    color = MaterialTheme.colors.secondary
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                backgroundColor = MaterialTheme.colors.background,
                cursorColor = MaterialTheme.colors.primary,
                focusedBorderColor = MaterialTheme.colors.primary,
                unfocusedBorderColor = MaterialTheme.colors.primaryVariant

            ),

            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            )


        )

        OutlinedTextField(
            value = email,
            modifier = Modifier.background(color = MaterialTheme.colors.background),
            onValueChange = {
                email = it
            },
            label = {
                Text(
                    text = "What is your Email",
                    color = MaterialTheme.colors.secondary
                )
            },
            placeholder = {
                Text(
                    text = "Enter your Email",
                    color = MaterialTheme.colors.secondary
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                backgroundColor = MaterialTheme.colors.background,
                cursorColor = MaterialTheme.colors.primary,
                focusedBorderColor = MaterialTheme.colors.primary,
                unfocusedBorderColor = MaterialTheme.colors.primaryVariant

            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            )
        )

        OutlinedTextField(
            value = password,
            modifier = Modifier.background(color = MaterialTheme.colors.background),
            onValueChange = {
                password = it
            },
            label = {
                Text(
                    text = "Create a password",
                    color = MaterialTheme.colors.secondary
                )
            },
            placeholder = {
                Text(
                    text = "Enter your password",
                    color = MaterialTheme.colors.secondary
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                backgroundColor = MaterialTheme.colors.background,
                cursorColor = MaterialTheme.colors.primary,
                focusedBorderColor = MaterialTheme.colors.primary,
                unfocusedBorderColor = MaterialTheme.colors.primaryVariant
            ),

            visualTransformation =
                if(showPassword) VisualTransformation.None else PasswordVisualTransformation(),

            trailingIcon = {
                IconButton(onClick = { showPassword = !showPassword }) {
                    Icon(
                        imageVector =
                            if (showPassword) Icons.Outlined.VisibilityOff else Icons.Outlined.Visibility,
                        contentDescription =
                            if (showPassword) "Show Password" else "Hide Password"
                    )
                }
            },

            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            )
        )

        OutlinedTextField(
            value = password,
            modifier = Modifier.background(color = MaterialTheme.colors.background),
            onValueChange = {
                password = it
            },
            label = {
                Text(
                    text = "Confirm a password",
                    color = MaterialTheme.colors.secondary
                )
            },
            placeholder = {
                Text(
                    text = "Enter your password",
                    color = MaterialTheme.colors.secondary
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                backgroundColor = MaterialTheme.colors.background,
                cursorColor = MaterialTheme.colors.primary,
                focusedBorderColor = MaterialTheme.colors.primary,
                unfocusedBorderColor = MaterialTheme.colors.primaryVariant
            ),

            visualTransformation =
            if(showPassword) VisualTransformation.None else PasswordVisualTransformation(),

            trailingIcon = {
                IconButton(onClick = { showPassword = !showPassword }) {
                    Icon(
                        imageVector =
                        if (showPassword) Icons.Outlined.VisibilityOff else Icons.Outlined.Visibility,
                        contentDescription =
                        if (showPassword) "Show Password" else "Hide Password"
                    )
                }
            },

            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            )
        )

    }
}