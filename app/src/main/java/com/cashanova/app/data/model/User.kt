package com.cashanova.app.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val username: String,
    val password: String,
    val fullName: String,
    val surname: String,
    val email: String,
    val contactNumber: String,
    val dateOfBirth: String
)
