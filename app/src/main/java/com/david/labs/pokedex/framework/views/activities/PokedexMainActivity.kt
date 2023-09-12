package com.david.labs.pokedex.framework.views.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.david.labs.R
import com.david.labs.databinding.ActivityPokedexBinding
import com.david.labs.pokedex.framework.viewmodel.PokedexViewModel
import com.david.labs.pokedex.framework.views.fragments.PokedexFragment
import com.david.labs.pokedex.framework.views.fragments.SearchFragment
import com.david.labs.pokedex.utils.Constants


class PokedexMainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPokedexBinding
    private val viewModel: PokedexViewModel by viewModels()
    private lateinit var currentFragment: Fragment
    private var currentMenuOption: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeBinding()
        initializeObservers()
        initializeListeners()
        exchangeCurrentFragment(PokedexFragment(), Constants.MENU_POKEDEX)
    }

    private fun initializeListeners() {
        binding.bottomNavigationView.selectedItemId = R.id.pokedex
        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.pokedex -> {
                    selectMenuOption(Constants.MENU_POKEDEX)
                    true
                }

                R.id.search -> {
                    selectMenuOption(Constants.MENU_SEARCH)
                    true
                }

                else -> false
            }
        }
    }

    private fun selectMenuOption(menuOption: String) {
        if (menuOption == currentMenuOption) {
            return
        }

        when (menuOption) {
            Constants.MENU_POKEDEX -> {
                exchangeCurrentFragment(PokedexFragment(), Constants.MENU_POKEDEX)
            }

            Constants.MENU_SEARCH -> {
                exchangeCurrentFragment(SearchFragment(), Constants.MENU_SEARCH)
            }
        }
    }

    private fun initializeBinding() {
        binding = ActivityPokedexBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun initializeObservers() {

    }

    private fun exchangeCurrentFragment(newFragment: Fragment, newMenuOption: String) {
        currentFragment = newFragment

        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment_content_main, currentFragment)
            .commit()

        currentMenuOption = newMenuOption
    }
}
