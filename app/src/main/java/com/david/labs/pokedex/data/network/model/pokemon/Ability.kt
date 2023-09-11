package com.david.labs.pokedex.data.network.model.pokemon

data class Ability(
    val ability: AbilityX,
    val is_hidden: Boolean,
    val slot: Int
)