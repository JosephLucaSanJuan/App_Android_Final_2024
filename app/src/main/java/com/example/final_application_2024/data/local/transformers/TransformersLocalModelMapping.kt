package com.example.final_application_2024.data.local.transformers

import com.example.final_application_2024.data.Transformer

fun Transformer.toLocal(): TransformersEntity {
    return TransformersEntity(
        id = this.id,
        name = this.name,
        altMode = this.alternateMode,
        gender = this.gender
    )
}

fun List<Transformer>.toLocal():List<TransformersEntity>{
    return this.map { p -> p.toLocal() }
}

fun TransformersEntity.toExternal():Transformer{
    return Transformer(
        id = this.id,
        name = this.name,
        alternateMode = this.altMode,
        gender = this.gender
    )
}

fun List<TransformersEntity>.toExternal() = map(TransformersEntity::toExternal)