package com.example.final_application_2024.data.local.users

import com.example.final_application_2024.data.User

interface UsersLocalDataSource {
    suspend fun login(email:String, password:String)
    suspend fun register(username:String, email:String, password:String)
    suspend fun logout()
    suspend fun saveUser(user:User)
    suspend fun retrieveUser(): User?
    suspend fun clearUser()
}