package com.example.final_application_2024.data

import com.example.final_application_2024.data.remote.FactionListItemResponse
import com.example.final_application_2024.data.remote.FactionListResponse
import com.example.final_application_2024.data.remote.TransformersListItemResponse
import com.example.final_application_2024.data.remote.TransformersListResponse

fun TransformersListResponse.toExternal() = results.map(TransformersListItemResponse::toExternal)

fun TransformersListItemResponse.toExternal(): Transformer {
    return Transformer(
        id = this.id,
        name = this.name,
        alternateMode = this.altMode,
        gender = this.gender
    )
}

fun TransformersListResponse.toLocal():List<Transformer> {
    return results.map { p -> p.toLocal() }
}

fun TransformersListItemResponse.toLocal(): Transformer {
    return Transformer(
        id = this.id,
        name = this.name,
        alternateMode = this.altMode,
        gender = this.gender
    )
}

fun FactionListResponse.toExternal() = results.map(FactionListItemResponse::toExternal)

fun FactionListItemResponse.toExternal(): Faction {
    return Faction(
        id = this.id,
        name = this.name
    )
}