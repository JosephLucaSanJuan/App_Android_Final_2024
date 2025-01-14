package com.example.final_application_2024.data.remote

import android.security.keystore.UserNotAuthenticatedException
import com.example.final_application_2024.data.User
import com.example.final_application_2024.data.toUser
import javax.inject.Inject

class UserRemoteDatabase @Inject constructor(
    private val api: TransformersApi
):UserRemoteDataSource {
    override suspend fun login(email: String, password: String): Result<User> {
        val response = api.login(LoginResponseBody(email, password))
        return if (response.isSuccessful) {
            Result.success(response.body()!!.toUser())
        } else {
            Result.failure(UserNotAuthenticatedException())
        }
    }

    override suspend fun register(
        username: String,
        email: String,
        password: String
    ): Result<User> {
        val response = api.register(RegisterResponseBody(username, email, password))
        return if (response.isSuccessful) {
            Result.success(response.body()!!.toUser())
        } else {
            Result.failure(UserNotAuthenticatedException())
        }
    }

    override suspend fun logout() {
        TODO("Not yet implemented")
    }
}