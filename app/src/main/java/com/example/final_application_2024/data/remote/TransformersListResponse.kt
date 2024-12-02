package com.example.final_application_2024.data.remote

data class TransformersListResponse(
    val count:Int,
    val next:String,
    val results:List<TransformersListItemResponse>
)

data class TransformersListItemResponse(
    val id:String,
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
    val id:String,
    val name:String
)

