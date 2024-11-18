package com.example.final_application_2024.data.remote

data class TransformersListResponse(
    val count:Int,
    val next:String,
    val results:List<TransformersListItemResponse>
)

data class TransformersListItemResponse(
    val name:String,
    val url:String
)