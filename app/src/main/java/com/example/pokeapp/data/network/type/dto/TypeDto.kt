package com.example.pokeapp.data.network.type.dto

import com.google.gson.annotations.SerializedName

data class TypeDto(
    val id: Int,
    val name: String,

    @SerializedName("damage_relations")
    val damageRelations: DamageRelationsDto,

    val sprites: TypeSpritesDto
)

data class DamageRelationsDto(

    @SerializedName("double_damage_from")
    val doubleDamageFrom: List<TypeSlotDto>,

    @SerializedName("double_damage_to")
    val doubleDamageTo: List<TypeSlotDto>,

    @SerializedName("half_damage_from")
    val halfDamageFrom: List<TypeSlotDto>,

    @SerializedName("half_damage_to")
    val halfDamageTo: List<TypeSlotDto>,

    @SerializedName("no_damage_from")
    val noDamageFrom: List<TypeSlotDto>,

    @SerializedName("no_damage_to")
    val noDamageTo: List<TypeSlotDto>
)

data class TypeSpritesDto(
    @SerializedName("generation-ix")
    val generationIx: GenerationIxDto?
)

data class GenerationIxDto(
    @SerializedName("scarlet-violet")
    val scarletViolet: ScarletVioletSpritesDto?
)

data class ScarletVioletSpritesDto(
    @SerializedName("name_icon")
    val nameIcon: String?
)

data class TypeSlotDto(
    val name: String,
    val url: String
) {
    val id: Int
        get() = url
            .trimEnd('/')
            .substringAfterLast('/')
            .toInt()
}