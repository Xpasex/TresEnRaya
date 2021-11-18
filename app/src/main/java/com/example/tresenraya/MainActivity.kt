package com.example.tresenraya

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tresenraya.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.botonPlay.setOnClickListener {
            //Verificar si llenó los campos
            if(binding.etJugador1.text.toString().trim().equals("")
                || binding.etJugador2.text.toString().trim().equals("") ){
                Toast.makeText(this, "Debes especificar todos los jugadores.", Toast.LENGTH_SHORT).show()
            }else {
                empezar()
            }
        }

    }

    fun empezar() : Unit{
        val i : Intent = Intent(this, Juego::class.java)
        i.putExtra("jugador1", binding.etJugador1.text.toString())
        i.putExtra("jugador2", binding.etJugador2.text.toString())
        startActivity(i)
    }

    fun VolverInicio(view: android.view.View) {

    }

}