package com.example.final_application_2024.data

interface UserRepository {
    suspend fun login(email:String, password:String):Result<User>
    suspend fun register(username: String, email: String, password: String):Result<User>
    suspend fun logout()
}