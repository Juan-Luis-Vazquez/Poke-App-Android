package com.example.pokeapp.domain.model.type

enum class PokemonType(val value: String) {

    NORMAL("normal"),
    FIRE("fire"),
    WATER("water"),
    ELECTRIC("electric"),
    GRASS("grass"),
    ICE("ice"),
    FIGHTING("fighting"),
    POISON("poison"),
    GROUND("ground"),
    FLYING("flying"),
    PSYCHIC("psychic"),
    BUG("bug"),
    ROCK("rock"),
    GHOST("ghost"),
    DRAGON("dragon"),
    DARK("dark"),
    STEEL("steel"),
    FAIRY("fairy");

    companion object {
        fun from(value: String): PokemonType {
            return entries.firstOrNull { it.value == value }
                ?: NORMAL
        }
    }
}