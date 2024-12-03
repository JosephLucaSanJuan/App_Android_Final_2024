package com.example.final_application_2024.data

import com.example.final_application_2024.data.local.users.UsersLocalDataSource
import com.example.final_application_2024.data.remote.UserRemoteDataSource
import javax.inject.Inject

class DefaultUserRepository @Inject constructor(
    private val localDataSource: UsersLocalDataSource,
    private val remoteDataSource: UserRemoteDataSource
):UserRepository {
    override suspend fun login(email: String, password: String) {
        localDataSource.login(email, password)
    }

    override suspend fun register(name: String, surname: String, email: String, password: String) {
        remoteDataSource.register(name, surname, email, password)
    }

    override suspend fun logout() {
        remoteDataSource.logout()
    }
}