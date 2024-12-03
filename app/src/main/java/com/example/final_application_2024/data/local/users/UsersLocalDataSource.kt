package com.example.final_application_2024.data.local.users

interface UsersLocalDataSource {
    suspend fun login(email:String, password:String)
    suspend fun register(name:String, surname:String, email:String, password:String)
    suspend fun logout()
}