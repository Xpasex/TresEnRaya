package com.example.tresenraya

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tresenraya.databinding.DisenofinalBinding

 class Final : AppCompatActivity() {
    lateinit var binding2: DisenofinalBinding
    //Instancia con mainActivity pa conseguir los jugadores name.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding2 = DisenofinalBinding.inflate(layoutInflater)
        setContentView(binding2.root)
        ganador()
        //Botones de navegación.
        binding2.botonSalir.setOnClickListener {

        }


    }
    //Verificar al ganador.
    fun ganador() {
        //Conseguir el nombre de los jugadores.
    val bundle2 = intent.extras
    val jugador1 = bundle2?.get("jugador11") ; val jugador2 = bundle2?.get("jugador22")





//Si gana uno poner esto
        if (jugador1win) {
            binding2.labelGanador.setText("$jugador1")
            binding2.imageView2.setImageResource(R.drawable.imgtrofeo)


            //Sino, esto
        } else if (jugador2win) {

            binding2.labelGanador.setText("$jugador2")
            binding2.imageView2.setImageResource(R.drawable.imgtrofeo)


        }
        //Si no ganó nadie, aparecerá empate que es la pantalla por defecto.
    }
     //Volver a la pantalla principal
     fun volver(){
         val intent40 = Intent(this, MainActivity::class.java)
         startActivity(intent40)
     }

}