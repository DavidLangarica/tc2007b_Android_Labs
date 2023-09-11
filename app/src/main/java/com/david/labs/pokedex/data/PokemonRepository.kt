package com.david.labs.pokedex.data

import com.david.labs.pokedex.data.network.PokemonApiClient
import com.david.labs.pokedex.data.network.model.PokedexObject
import com.david.labs.pokedex.data.network.model.pokemon.Pokemon

class PokemonRepository() {
    private val apiPokemon = PokemonApiClient()

    suspend fun getPokemonList(limit: Int): PokedexObject? = apiPokemon.getPokemonList(limit)

    suspend fun getPokemonInfo(numberPokemon: Int): Pokemon? =
        apiPokemon.getPokemonInfo(numberPokemon)
}