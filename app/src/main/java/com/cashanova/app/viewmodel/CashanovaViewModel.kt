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

    fun validateLoginFields(): Boolean {
        return when {
            username.isBlank() -> {
                message = "Please enter your username"
                false
            }
            password.isBlank() -> {
                message = "Please enter your password"
                false
            }
            else -> true
        }
    }

    fun registerUser(onSuccess: () -> Unit) {
        if (!validateRegisterFields()) return

        viewModelScope.launch {
            isLoading = true

            val existingUser = userDao.getUserByUsername(username)

            if (existingUser != null) {
                message = "Username already exists"
                isLoading = false
                return@launch
            }

            val user = User(
                username = username.trim(),
                password = password.trim(),
                fullName = fullName.trim(),
                surname = surname.trim(),
                email = email.trim(),
                contactNumber = contactNumber.trim(),
                dateOfBirth = dateOfBirth.trim()
            )

            userDao.insertUser(user)

            message = "Registration successful. Please log in."
            clearAuthFields()
            isLoading = false
            onSuccess()
        }
    }

    fun loginUser(onSuccess: () -> Unit) {
        if (!validateLoginFields()) return

        viewModelScope.launch {
            isLoading = true

            val user = userDao.login(username.trim(), password.trim())

            if (user == null) {
                message = "Invalid username or password"
                isLoading = false
                return@launch
            }

            sessionManager.saveSession(user.id, user.username)

            message = "Login successful"
            isLoading = false
            onSuccess()
        }
    }

    fun clearAuthFields() {
        username = ""
        password = ""
        fullName = ""
        surname = ""
        email = ""
        contactNumber = ""
        dateOfBirth = ""
    }
}



