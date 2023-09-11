package com.david.labs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.david.labs.pokedex.framework.views.PokedexActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val pokedexButton = findViewById<Button>(R.id.pokedexButton)
        pokedexButton.setOnClickListener{navigateToLab2()}
    }

    private fun navigateToLab2() {
        val intent = Intent(this, PokedexActivity::class.java)
        startActivity(intent)
    }
}