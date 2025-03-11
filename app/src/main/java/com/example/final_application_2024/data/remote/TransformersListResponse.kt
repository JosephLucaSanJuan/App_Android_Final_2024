package com.example.final_application_2024.data.remote

import com.example.final_application_2024.data.Faction

data class TransformersListResponse(
    /*val count:Int,
    val next:String,*/
    val data:List<TransformersListItemResponse>
)

data class TransformersListItemResponse(
    val id:Int,
    val attributes:TransformerAttributes
)

data class TransformerAttributes(
    val name:String,
    val altMode:String,
    val gender:String
)

data class TransformerCreatePayloadWrapper(
    val data:TransformerCreatePayload
)

data class TransformerCreateWrapper(
    val data: TransformersListItemResponse
)

data class TransformerCreatePayload(
    val name:String,
    val altMode:String,
    val gender:String
)

data class FactionListResponse(
    val data: List<FactionListItemResponse>
    /*
    val count:Int,
    val next:String,
    val results:List<FactionListItemResponse>*/
)
data class FactionCreateWrapper(
    val data: FactionListItemResponse
)

data class FactionUpdatePayloadWrapper(
    val data:Faction
)

data class FactionUpdateWrapper(
    val data: FactionListItemResponse
)

data class FactionListItemResponse(
    val id:Int,
    val attributes:FactionAttributes
)

data class FactionAttributes(
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
    val name:String,
    val surname:String,
    val email:String,
    val password:String
)

data class RegisterResponseBody(
    val name:String,
    val surname:String,
    val username:String,
    val email:String,
    val password:String
)