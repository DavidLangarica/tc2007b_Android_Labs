package com.david.labs.pokedex.framework.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.david.labs.R
import com.david.labs.databinding.ActivityPokedexBinding
import com.david.labs.pokedex.data.network.model.PokemonBase
import com.david.labs.pokedex.framework.adapters.PokemonAdapter
import com.david.labs.pokedex.framework.viewmodel.PokedexViewModel

class PokedexActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPokedexBinding
    private val adapter: PokemonAdapter = PokemonAdapter()
    private val viewModel: PokedexViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokedex)

        initializeBinding()
        initializeObservers()
        viewModel.getPokemonList()
    }

    private fun initializeObservers() {
        viewModel.pokedexObjectLiveData.observe(this) { pokedexObject ->
            if (pokedexObject != null) {
                setUpRecyclerView(pokedexObject.results)
            }
        }
    }

    private fun initializeBinding() {
        binding = ActivityPokedexBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setUpRecyclerView(dataForList: ArrayList<PokemonBase>) {
        binding.RVPokemon.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        binding.RVPokemon.layoutManager = linearLayoutManager
        adapter.PokemonAdapter(dataForList, this)
        binding.RVPokemon.adapter = adapter
    }
}