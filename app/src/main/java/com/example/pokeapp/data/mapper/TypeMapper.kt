package com.example.pokeapp.data.mapper

import com.example.pokeapp.data.local.type.entity.TypeEntity
import com.example.pokeapp.data.network.type.dto.TypeDto
import com.example.pokeapp.data.network.type.dto.TypeItemDto
import com.example.pokeapp.domain.model.type.Type
import com.example.pokeapp.domain.model.type.TypeDetail

fun TypeItemDto.toDomain(): Type {
    return Type(
        name = name
    )
}

fun TypeDto.toDomain(): TypeDetail {
    return TypeDetail(
        id = id,
        name = name,
        iconUrl = sprites
            .generationIx
            ?.scarletViolet
            ?.nameIcon
            ?: "",

        weaknesses = damageRelations.doubleDamageFrom.map { it.name },
        strengths = damageRelations.doubleDamageTo.map { it.name },
        resistances = damageRelations.halfDamageFrom.map { it.name },
        immunities = damageRelations.noDamageFrom.map { it.name }
    )
}

fun TypeEntity.toDomain(): TypeDetail {
    return TypeDetail(
        id = id,
        name = name,
        iconUrl = iconUrl,
        weaknesses = weaknesses.split(","),
        strengths = strengths.split(","),
        resistances = resistances.split(","),
        immunities = immunities.split(",")
    )
}

fun TypeDetail.toEntity(): TypeEntity {
    return TypeEntity(
        id = id,
        name = name,
        iconUrl = iconUrl,
        weaknesses = weaknesses.joinToString(","),
        strengths = strengths.joinToString(","),
        resistances = resistances.joinToString(","),
        immunities = immunities.joinToString(",")
    )
}