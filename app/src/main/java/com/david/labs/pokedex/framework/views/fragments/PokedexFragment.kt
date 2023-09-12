package com.david.labs.pokedex.framework.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.david.labs.R
import com.david.labs.databinding.FragmentPokedexBinding
import com.david.labs.pokedex.data.network.model.PokemonBase
import com.david.labs.pokedex.framework.adapters.PokemonAdapter
import com.david.labs.pokedex.framework.viewmodel.PokedexViewModel

class PokedexFragment : Fragment() {
    private var _binding: FragmentPokedexBinding? = null

    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!

    private lateinit var viewModel: PokedexViewModel

    private lateinit var recyclerView: RecyclerView
    private val adapter: PokemonAdapter = PokemonAdapter()
    private lateinit var data: ArrayList<PokemonBase>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[PokedexViewModel::class.java]
        _binding = FragmentPokedexBinding.inflate(inflater, container, false)
        val root: View = binding.root

        data = ArrayList()

        initializeComponents(root)
        initializeObservers()
        viewModel.getPokemonList()

        return root
    }

    private fun setUpRecyclerView(dataForList: ArrayList<PokemonBase>) {
        recyclerView.setHasFixedSize(true)
        /*val linearLayoutManager = LinearLayoutManager(
            requireContext(),        LinearLayoutManager.VERTICAL,        false)*/
        val gridLayoutManager = GridLayoutManager(
            requireContext(),
            3,
            GridLayoutManager.VERTICAL,
            false
        )
        recyclerView.layoutManager = gridLayoutManager
        adapter.PokemonAdapter(dataForList, requireContext())
        recyclerView.adapter = adapter
    }

    private fun initializeObservers() {
        viewModel.pokedexObjectLiveData.observe(viewLifecycleOwner) { pokedexObject ->
            if (pokedexObject != null) {
                setUpRecyclerView(pokedexObject.results)
            }
        }
    }

    private fun initializeComponents(root: View) {
        recyclerView = root.findViewById(R.id.RVPokemon)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}