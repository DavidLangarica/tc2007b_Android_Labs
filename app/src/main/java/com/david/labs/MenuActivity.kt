package com.david.labs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.david.labs.pokedex.framework.views.activities.SplashscreenActivity
import com.david.labs.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        initializeBinding()
        initializeButtons()

    }

    private fun initializeBinding() {
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun initializeButtons() {
        binding.pokedexButton.setOnClickListener { navigateToPokedex() }
    }

    private fun navigateToPokedex() {
        val intent = Intent(this, SplashscreenActivity::class.java)
        startActivity(intent)
    }
}