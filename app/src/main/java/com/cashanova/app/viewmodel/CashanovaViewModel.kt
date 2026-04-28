package com.cashanova.app.viewmodel

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.cashanova.app.data.AppDatabase
import com.cashanova.app.data.SessionManager
import com.cashanova.app.data.model.User
import kotlinx.coroutines.launch

class CashanovaViewModel(application: Application) : AndroidViewModel(application) {

    private val database = AppDatabase.getDatabase(application)
    private val userDao = database.userDao()

    val sessionManager = SessionManager(application)

    var username by mutableStateOf("")
    var password by mutableStateOf("")
    var fullName by mutableStateOf("")
    var surname by mutableStateOf("")
    var email by mutableStateOf("")
    var contactNumber by mutableStateOf("")
    var dateOfBirth by mutableStateOf("")

    var message by mutableStateOf("")
    var isLoading by mutableStateOf(false)

    fun clearMessage() {
        message = ""
    }

    fun validateRegisterFields(): Boolean {
        return when {
            fullName.isBlank() -> {
                message = "Please enter your full name"
                false
            }
            surname.isBlank() -> {
                message = "Please enter your surname"
                false
            }
            username.isBlank() -> {
                message = "Please enter a username"
                false
            }
            password.isBlank() -> {
                message = "Please enter a password"
                false
            }
            email.isBlank() -> {
                message = "Please enter your email address"
                false
            }
            contactNumber.isBlank() -> {
                message = "Please enter your contact number"
                false
            }
            dateOfBirth.isBlank() -> {
                message = "Please enter your date of birth"
                false
            }
            else -> true
        }
    }
}

