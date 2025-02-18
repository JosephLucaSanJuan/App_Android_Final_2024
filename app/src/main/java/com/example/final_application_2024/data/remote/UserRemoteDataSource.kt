package com.example.final_application_2024.data.remote

import com.example.final_application_2024.data.User

interface UserRemoteDataSource {
    suspend fun login(email:String, password:String):Result<User>
    suspend fun register(name:String, surname:String, username:String, email:String, password:String):Result<User>
    suspend fun logout()
}