package com.cashanova.app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.cashanova.app.viewmodel.CashanovaViewModel

@Composable
fun SearchScreen(
    navController: NavController,
    viewModel: CashanovaViewModel
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Search Expenses",
            style = MaterialTheme.typography.headlineLarge
        )

        Text(
            text = "Search functionality will be connected when expense records are added."
        )
    }
}
