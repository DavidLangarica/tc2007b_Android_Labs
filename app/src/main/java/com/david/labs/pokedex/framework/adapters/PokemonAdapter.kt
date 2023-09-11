package com.david.labs.pokedex.framework.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.david.labs.databinding.ItemPokemonBinding
import com.david.labs.pokedex.data.network.model.PokemonBase
import com.david.labs.pokedex.framework.adapters.viewholders.PokemonViewHolder

class PokemonAdapter : RecyclerView.Adapter<PokemonViewHolder>() {
    var data: ArrayList<PokemonBase> = ArrayList()
    lateinit var context: Context

    fun PokemonAdapter(basicData: ArrayList<PokemonBase>, context: Context) {
        this.data = basicData
        this.context = context
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item, context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val binding = ItemPokemonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}