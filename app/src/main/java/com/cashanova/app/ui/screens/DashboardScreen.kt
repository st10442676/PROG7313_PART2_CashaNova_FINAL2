package com.cashanova.app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.cashanova.app.navigation.Routes
import com.cashanova.app.ui.components.GoldButton
import com.cashanova.app.viewmodel.CashanovaViewModel

@Composable
fun DashboardScreen(
    navController: NavController,
    viewModel: CashanovaViewModel
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Welcome, ${viewModel.sessionManager.getUsername()}",
            style = MaterialTheme.typography.headlineLarge
        )

        Spacer(modifier = Modifier.height(24.dp))

        GoldButton(
            text = "View Expenses",
            modifier = Modifier.fillMaxWidth()
        ) {
            navController.navigate(Routes.EXPENSES)
        }

        Spacer(modifier = Modifier.height(12.dp))

        GoldButton(
            text = "Search Expenses",
            modifier = Modifier.fillMaxWidth()
        ) {
            navController.navigate(Routes.SEARCH)
        }

        Spacer(modifier = Modifier.height(12.dp))

        GoldButton(
            text = "Logout",
            modifier = Modifier.fillMaxWidth()
        ) {
            viewModel.logout()
            navController.navigate(Routes.LOGIN) {
                popUpTo(Routes.DASHBOARD) { inclusive = true }
            }
        }
    }
}
