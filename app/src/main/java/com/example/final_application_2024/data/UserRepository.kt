package com.example.final_application_2024.data

interface UserRepository {
    suspend fun login(email:String, password:String)
    suspend fun register(name: String, surname: String, email: String, password: String)
    suspend fun logout()
}