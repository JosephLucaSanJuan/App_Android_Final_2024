package com.example.final_application_2024.data.remote

import android.security.keystore.UserNotAuthenticatedException
import com.example.final_application_2024.data.User
import com.example.final_application_2024.data.toUser
import java.util.UUID
import javax.inject.Inject

class UserRemoteDatabase @Inject constructor(
    private val api: TransformersApi
):UserRemoteDataSource {
    private val _users = mutableListOf<User>()

    override suspend fun login(email: String, password: String): Result<User> {
        val response = api.login(LoginResponseBody(email, password))
        return if (response.isSuccessful) {
            Result.success(response.body()!!.toUser())
        } else {
            Result.failure(UserNotAuthenticatedException())
        }
        /*val user = getUser(email, password)
        user?.let {
            if (it.password == password) {
                val token = UUID.randomUUID()
                val position = _users.indexOf(it)
                _users[position].token = token.toString()
                return Result.success(_users[position])
            } else {
                return Result.failure(UserNotAuthenticatedException())
            }
        }
        return Result.failure(UserNotAuthenticatedException())*/
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

    /*private fun userExists(username: String, email: String) = getUser(username, email)==null

    private fun getUser(email: String, password: String) = _users.find {
            u -> (u.password == password || u.email == email)
    }

    private fun getUser(identifier: String) = _users.find {
            u -> (u.username == identifier || u.email == identifier)
    }*/
}