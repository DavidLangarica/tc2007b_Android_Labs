package com.david.labs.pokedex.domain

import com.david.labs.pokedex.data.PokemonRepository
import com.david.labs.pokedex.data.network.model.PokedexObject

class PokemonListRequirement {
    private val repository = PokemonRepository()

    suspend operator fun invoke(
        limit:Int
    ): PokedexObject? = repository.getPokemonList(limit)
}