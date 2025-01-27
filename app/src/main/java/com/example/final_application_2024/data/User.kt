package com.example.final_application_2024.data

data class User(
    val id:Int,
    val username:String,
    //val surname:String = "",
    val email:String,
    //val password:String,
    var token:String
) {
    val isLoggedIn:Boolean
        get() = token != null
}
