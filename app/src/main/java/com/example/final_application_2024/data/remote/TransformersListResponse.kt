package com.example.final_application_2024.data.remote

data class TransformersListResponse(
    val count:Int,
    val next:String,
    val results:List<TransformersListItemResponse>
)

data class TransformersListItemResponse(
    val id:Int,
    val name:String,
    val altMode:String,
    val gender:String
)

data class FactionListResponse(
    val count:Int,
    val next:String,
    val results:List<FactionListItemResponse>
)

data class FactionListItemResponse(
    val id:Int,
    val name:String
)

data class AuthResponseBody(
    val jwt:String,
    val user:AuthResponseUser
)

data class LoginResponseBody(
    val identifier:String,
    val password:String
)

data class AuthResponseUser(
    val id:Int,
    val username:String,
    //val surname:String,
    val email:String,
    //val password:String
)

data class RegisterResponseBody(
    val name:String,
    val surname:String,
    val email:String,
    val password:String
)