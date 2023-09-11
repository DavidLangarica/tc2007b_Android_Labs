package com.david.labs.pokedex.domain

import com.david.labs.pokedex.data.PokemonRepository
import com.david.labs.pokedex.data.network.model.pokemon.Pokemon

class PokemonInfoRequirement {
    private val repository = PokemonRepository()

    suspend operator fun invoke(
        numberPokemon: Int
    ): Pokemon? = repository.getPokemonInfo(numberPokemon)
}