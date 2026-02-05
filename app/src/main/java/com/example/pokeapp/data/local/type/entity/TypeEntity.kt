package com.example.pokeapp.data.local.type.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "types")
data class TypeEntity(

    @PrimaryKey
    val id: Int,

    val name: String,

    val iconUrl: String,

    val weaknesses: String,
    val strengths: String,
    val resistances: String,
    val immunities: String
)