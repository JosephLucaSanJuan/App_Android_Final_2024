package com.example.final_application_2024.data

import com.example.final_application_2024.data.local.users.UsersLocalDataSource
import com.example.final_application_2024.data.remote.UserRemoteDataSource
import javax.inject.Inject

class DefaultUserRepository @Inject constructor(
    private val localDataSource: UsersLocalDataSource,
    private val remoteDataSource: UserRemoteDataSource
):UserRepository {
    override suspend fun login(email: String, password: String):Result<User> {
        val result = remoteDataSource.login(email, password)
        if (result.isSuccess) {
            localDataSource.saveUser(result.getOrNull()!!)
        }
        return result
    }

    override suspend fun register(username: String, email: String, password: String):Result<User> {
        return remoteDataSource.register(username, email, password)
    }

    override suspend fun logout() {
        localDataSource.logout()
    }
}