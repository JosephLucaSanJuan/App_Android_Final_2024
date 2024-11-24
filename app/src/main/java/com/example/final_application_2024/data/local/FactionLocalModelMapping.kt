package com.example.final_application_2024.data.local

import com.example.final_application_2024.data.Faction

fun Faction.toLocal():FactionEntity{
    return FactionEntity(
        id = this.id,
        name = this.name
    )
}

fun List<Faction>.toLocal():List<FactionEntity> = map(Faction::toLocal)

fun FactionEntity.toExternal():Faction{
    return Faction(
        id = this.id,
        name = this.name
    )
}

fun List<FactionEntity>.toExternal():List<Faction> = map(FactionEntity::toExternal)