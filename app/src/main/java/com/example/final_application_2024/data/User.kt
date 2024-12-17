package com.example.final_application_2024.data

data class User(
    val id:Int,
    val name:String,
    // TODO REMOVE THIS
    val surname:String = "",
    val email:String,
    val password:String = "",
    var token:String
) {
    val isLoggedIn:Boolean
        get() = token != null
}
