package com.example.final_application_2024.data.local.users

import com.example.final_application_2024.data.User
import javax.inject.Inject

class UserLocalDatabase @Inject constructor():UsersLocalDataSource {
    private var _user:User? = null
    override suspend fun login(email: String, password: String) {
        TODO("Not yet implemented")
    }

    override suspend fun register(username: String, email: String, password: String) {
        TODO("Not yet implemented")
    }

    override suspend fun logout() {
        TODO("Not yet implemented")
    }

    override suspend fun saveUser(user: User) {
        _user = user
    }

    override suspend fun retrieveUser(): User? {
        return _user
    }

    override suspend fun clearUser() {
        _user = null
    }
}