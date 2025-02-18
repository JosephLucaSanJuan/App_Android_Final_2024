package com.example.final_application_2024.data.local.users

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.final_application_2024.data.User
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserLocalDatabaseDS @Inject constructor(
    private val preferences: DataStore<Preferences>
): UsersLocalDataSource {

    private val tokenKey = stringPreferencesKey("token")
    private val usernameKey = stringPreferencesKey("username")
    private val emailKey = stringPreferencesKey("email")
    private val idKey = intPreferencesKey("identifier")

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
        preferences.edit {
                p ->
            p[idKey] = user.id
            p[usernameKey] = user.username
            p[emailKey] = user.email
            user.token.let {
                p[tokenKey] = it
            }
        }
    }

    override suspend fun retrieveUser(): User? {
        val tokenFlow = preferences.data.map { p ->
            p[tokenKey]
        }

        val token = tokenFlow.firstOrNull()
        token?.let {
            return User(
                id = 0,
                name = "",
                surname = "",
                username = "",
                email = "",
                token = token
            )
        }
        return null
    }

    override suspend fun clearUser() {
        preferences.edit {
                p ->
            p[idKey] = 0
            p[usernameKey] = ""
            p[emailKey] = ""
            p[tokenKey] = ""

        }
    }
}