package com.example.final_application_2024.data

import com.example.final_application_2024.data.remote.AuthResponseBody
import com.example.final_application_2024.data.remote.AuthResponseUser
import com.example.final_application_2024.data.remote.FactionCreateWrapper
import com.example.final_application_2024.data.remote.FactionListItemResponse
import com.example.final_application_2024.data.remote.FactionListResponse
import com.example.final_application_2024.data.remote.RegisterResponseBody
import com.example.final_application_2024.data.remote.TransformersListItemResponse
import com.example.final_application_2024.data.remote.TransformersListResponse

fun TransformersListResponse.toExternal() = data.map(TransformersListItemResponse::toExternal)

fun TransformersListItemResponse.toExternal(): Transformer {
    return Transformer(
        id = this.id,
        name = this.attributes.name,
        alternateMode = this.attributes.altMode,
        gender = this.attributes.gender
    )
}

fun TransformersListResponse.toLocal():List<Transformer> {
    return data.map { p -> p.toLocal() }
}

fun TransformersListItemResponse.toLocal(): Transformer {
    return Transformer(
        id = this.id,
        name = this.attributes.name,
        alternateMode = this.attributes.altMode,
        gender = this.attributes.gender
    )
}

fun FactionListResponse.toExternal() = data.map(FactionListItemResponse::toExternal)

fun FactionListItemResponse.toExternal(): Faction {
    return Faction(
        id = this.id,
        name = this.attributes.name
    )
}

fun FactionListResponse.toLocal() = data.map(FactionListItemResponse::toLocal)

fun FactionListItemResponse.toLocal(): Faction {
    return Faction(
        id = this.id,
        name = this.attributes.name
    )
}

fun FactionCreateWrapper.toLocal(): Faction {
    return Faction(
        id = this.data.id,
        name = this.data.attributes.name
    )
}

fun AuthResponseBody.toUser(): User {
    return User(
        id = this.user.id,
        username = this.user.username,
        //surname = this.user.surname,
        email = this.user.email,
        //password = this.user.password,
        token = this.jwt
    )
}