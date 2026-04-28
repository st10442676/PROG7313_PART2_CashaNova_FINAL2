package com.cashanova.app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.cashanova.app.navigation.Routes
import com.cashanova.app.ui.components.GoldButton
import com.cashanova.app.ui.components.GoldTextField
import com.cashanova.app.viewmodel.CashanovaViewModel

@Composable
fun RegisterScreen(
    navController: NavController,
    viewModel: CashanovaViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Create Account",
            style = MaterialTheme.typography.displayLarge
        )

        Spacer(modifier = Modifier.height(18.dp))

        GoldTextField(
            value = viewModel.fullName,
            onValueChange = { viewModel.fullName = it },
            label = "Full Name",
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        GoldTextField(
            value = viewModel.surname,
            onValueChange = { viewModel.surname = it },
            label = "Surname",
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        GoldTextField(
            value = viewModel.username,
            onValueChange = { viewModel.username = it },
            label = "Username",
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        GoldTextField(
            value = viewModel.password,
            onValueChange = { viewModel.password = it },
            label = "Password",
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(10.dp))

        GoldTextField(
            value = viewModel.email,
            onValueChange = { viewModel.email = it },
            label = "Email",
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        GoldTextField(
            value = viewModel.contactNumber,
            onValueChange = { viewModel.contactNumber = it },
            label = "Contact Number",
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        GoldTextField(
            value = viewModel.dateOfBirth,
            onValueChange = { viewModel.dateOfBirth = it },
            label = "Date of Birth",
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        if (viewModel.message.isNotBlank()) {
            Text(text = viewModel.message)
            Spacer(modifier = Modifier.height(12.dp))
        }

        GoldButton(
            text = "Register",
            modifier = Modifier.fillMaxWidth()
        ) {
            // Register action added in next commit.
        }

        TextButton(
            onClick = {
                viewModel.clearMessage()
                navController.navigate(Routes.LOGIN)
            }
        ) {
            Text("Already have an account? Login")
        }
    }
}
