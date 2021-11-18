package com.example.tresenraya


/*
Jugador 1: X IMPAR.
Jugador 2: O PAR.
 */
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isInvisible
import com.example.tresenraya.databinding.VistaBinding

/*
Creación de las variables para que solo se seleccione el cuadro 1 vez.
 */

var a1 : Boolean = true
var a2 : Boolean = true
var a3 : Boolean = true
var a4 : Boolean = true
var a5 : Boolean = true
var a6 : Boolean = true
var a7 : Boolean = true
var a8 : Boolean = true
var a9 : Boolean = true

/*
Fin de la declaración
 */

/*
Booleanos para saber que jugador ganó.
 */
var jugador1win : Boolean = false
var jugador2win : Boolean = false

/*
Variable para saber si empataron.
 */
var num : Int = 0
/*
Marcar si fue victoria, de lo contrario fue empate.
 */
var victoria = false
//Creacion de un numero, si es par entonces es turno de jugador1, si es impar es turno de jugador2
//Se logra usando % (módulo)
private var turno : Int = 1


class Juego : AppCompatActivity(){
    lateinit var binding: VistaBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = VistaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Recibir los nombres de los jugadores.
        val bundle = intent.extras
        val jugador1 = bundle?.get("jugador1")
        val jugador2 = bundle?.get("jugador2")

        //Escribir de entrada que es el turno de jugador 1.
        binding.tvJugador.setText("Es el turno de: $jugador1")



        //Creación de los métodos para obtener el listado del click


        binding.imageButton1.setOnClickListener {
            //Comprobar si ya fue seleccionado.

            if(a1) {
                setImgSeleccionado(binding.imageButton1)
                marcar(binding.tv1)
                num++
                comprobacion()
                //Comprobar si ganó
                a1 = false

            }

        }
        binding.imageButton2.setOnClickListener {

            if(a2) {
                setImgSeleccionado(binding.imageButton2)
                marcar(binding.tv2)
                num++
                comprobacion()
                a2 = false
            }
        }
        binding.imageButton3.setOnClickListener {

            if(a3) {
                setImgSeleccionado(binding.imageButton3)
                marcar(binding.tv3)
                num++
                comprobacion()
                a3 = false
            }
        }
        binding.imageButton4.setOnClickListener {
            if(a4) {
                setImgSeleccionado(binding.imageButton4)
                marcar(binding.tv4)
                num++
                comprobacion()
                a4 = false
            }
        }
        binding.imageButton5.setOnClickListener {
            if(a5) {
                setImgSeleccionado(binding.imageButton5)
                marcar(binding.tv5)
                num++
                comprobacion()
                a5 = false
            }
        }
        binding.imageButton6.setOnClickListener {
            if(a6) {
                setImgSeleccionado(binding.imageButton6)
                marcar(binding.tv6)
                num++
                comprobacion()
                a6 = false
            }
        }
        binding.imageButton7.setOnClickListener {
            if(a7) {
                setImgSeleccionado(binding.imageButton7)
                marcar(binding.tv7)
                num++
                comprobacion()
                a7 = false
            }
        }
        binding.imageButton8.setOnClickListener {
            if(a8) {
                setImgSeleccionado(binding.imageButton8)
                marcar(binding.tv8)
                num++
                comprobacion()
                a8 = false
            }
        }
        binding.imageButton9.setOnClickListener {
            if(a9) {
                setImgSeleccionado(binding.imageButton9)
                marcar(binding.tv9)
                num++
                comprobacion()
                a9 = false
            }
        }




    }
    //Método para poner en blanco la imagen seleccionada.
    fun setImgSeleccionado(button : ImageButton){
        button.setImageResource(R.drawable.img200)
    }
    //Método para marcar seleccion.
    fun marcar(tv : TextView){
        //Recibir los nombres de los jugadores.
        var bundle = intent.extras
        val jugador1 = bundle?.get("jugador1")
        val jugador2 = bundle?.get("jugador2")

        //Turno del jugador uno.
        //Se saca el residuo dividiendo para 2, si es diferente de 0 el residuo, entonces es impar y toca una X.
        if(turno % 2 != 0){
           tv.setText("X")
            //Aumenta turno para que ahora el else se cumpla.
            turno++

            //Turno del jugador dos.
            binding.tvJugador.setText("Es el turno de: $jugador2")
            //Se saca el residuo dividiendo para 2, si NO es diferente de 0 el residuo, entonces es par y toca una O.
        }else{
            tv.setText("O")
                    //Turno del jugador uno.
            binding.tvJugador.setText("Es el turno de: $jugador1")
            //Aumenta turno para que ahora el if se cumpla.
            turno++
        }
    }


    //Método que comprueba si alguien gana.
    fun comprobacion(){

        //Primero comprobamos todo lo del jugador X (1, impar).
        //Eje recto de la primera fila -->
        if(binding.tv1.text.equals("X")){
            if(binding.tv2.text.equals("X")){
                if(binding.tv3.text.equals("X")){
                  //Ganó, pintar esas celdas de color verde y lo demás en rojo :]
                    binding.imageButton1.setImageResource(R.drawable.imgverde)
                    binding.imageButton2.setImageResource(R.drawable.imgverde)
                    binding.imageButton3.setImageResource(R.drawable.imgverde)
                    //Rojo
                    binding.imageButton4.setImageResource(R.drawable.imgrojo)
                    binding.imageButton5.setImageResource(R.drawable.imgrojo)
                    binding.imageButton6.setImageResource(R.drawable.imgrojo)
                    binding.imageButton7.setImageResource(R.drawable.imgrojo)
                    binding.imageButton8.setImageResource(R.drawable.imgrojo)
                    binding.imageButton9.setImageResource(R.drawable.imgrojo)
                    jugador1win = true

                }
            }
        }
        //Eje recto de la segunda fila -->
        if(binding.tv4.text.equals("X")){
            if(binding.tv5.text.equals("X")){
                if(binding.tv6.text.equals("X")){
                    //Ganó, pintar esas celdas de color verde y lo demás en rojo :]
                    binding.imageButton4.setImageResource(R.drawable.imgverde)
                    binding.imageButton5.setImageResource(R.drawable.imgverde)
                    binding.imageButton6.setImageResource(R.drawable.imgverde)
                    //Rojo
                    binding.imageButton1.setImageResource(R.drawable.imgrojo)
                    binding.imageButton2.setImageResource(R.drawable.imgrojo)
                    binding.imageButton3.setImageResource(R.drawable.imgrojo)
                    binding.imageButton7.setImageResource(R.drawable.imgrojo)
                    binding.imageButton8.setImageResource(R.drawable.imgrojo)
                    binding.imageButton9.setImageResource(R.drawable.imgrojo)
                    jugador1win = true
                }
            }
        }
        //Eje recto de la tercera fila fila -->
        if(binding.tv7.text.equals("X")){
            if(binding.tv8.text.equals("X")){
                if(binding.tv9.text.equals("X")){
                    //Ganó, pintar esas celdas de color verde y lo demás en rojo :]
                    binding.imageButton7.setImageResource(R.drawable.imgverde)
                    binding.imageButton8.setImageResource(R.drawable.imgverde)
                    binding.imageButton9.setImageResource(R.drawable.imgverde)
                    //Rojo
                    binding.imageButton4.setImageResource(R.drawable.imgrojo)
                    binding.imageButton5.setImageResource(R.drawable.imgrojo)
                    binding.imageButton6.setImageResource(R.drawable.imgrojo)
                    binding.imageButton1.setImageResource(R.drawable.imgrojo)
                    binding.imageButton2.setImageResource(R.drawable.imgrojo)
                    binding.imageButton3.setImageResource(R.drawable.imgrojo)
                    jugador1win = true
                }
            }
        }


        //Eje recto de la primera columna ^
        if(binding.tv1.text.equals("X")){
            if(binding.tv4.text.equals("X")){
                if(binding.tv7.text.equals("X")){
                    //Ganó, pintar esas celdas de color verde y lo demás en rojo :]
                    binding.imageButton1.setImageResource(R.drawable.imgverde)
                    binding.imageButton4.setImageResource(R.drawable.imgverde)
                    binding.imageButton7.setImageResource(R.drawable.imgverde)
                    //Rojo
                    binding.imageButton2.setImageResource(R.drawable.imgrojo)
                    binding.imageButton3.setImageResource(R.drawable.imgrojo)
                    binding.imageButton5.setImageResource(R.drawable.imgrojo)
                    binding.imageButton6.setImageResource(R.drawable.imgrojo)
                    binding.imageButton8.setImageResource(R.drawable.imgrojo)
                    binding.imageButton9.setImageResource(R.drawable.imgrojo)
                    jugador1win = true
                }
            }
        }
        //Eje recto de la segunda columna ^
        if(binding.tv2.text.equals("X")){
            if(binding.tv5.text.equals("X")){
                if(binding.tv8.text.equals("X")){
                    //Ganó, pintar esas celdas de color verde y lo demás en rojo :]
                    binding.imageButton2.setImageResource(R.drawable.imgverde)
                    binding.imageButton5.setImageResource(R.drawable.imgverde)
                    binding.imageButton8.setImageResource(R.drawable.imgverde)
                    //Rojo
                    binding.imageButton1.setImageResource(R.drawable.imgrojo)
                    binding.imageButton3.setImageResource(R.drawable.imgrojo)
                    binding.imageButton4.setImageResource(R.drawable.imgrojo)
                    binding.imageButton6.setImageResource(R.drawable.imgrojo)
                    binding.imageButton7.setImageResource(R.drawable.imgrojo)
                    binding.imageButton9.setImageResource(R.drawable.imgrojo)
                    jugador1win = true
                }
            }
        }
        //Eje recto de la tercer columna ^
        if(binding.tv3.text.equals("X")){
            if(binding.tv6.text.equals("X")){
                if(binding.tv9.text.equals("X")){
                    //Ganó, pintar esas celdas de color verde y lo demás en rojo :]
                    binding.imageButton3.setImageResource(R.drawable.imgverde)
                    binding.imageButton6.setImageResource(R.drawable.imgverde)
                    binding.imageButton9.setImageResource(R.drawable.imgverde)
                    //Rojo
                    binding.imageButton1.setImageResource(R.drawable.imgrojo)
                    binding.imageButton2.setImageResource(R.drawable.imgrojo)
                    binding.imageButton4.setImageResource(R.drawable.imgrojo)
                    binding.imageButton5.setImageResource(R.drawable.imgrojo)
                    binding.imageButton7.setImageResource(R.drawable.imgrojo)
                    binding.imageButton8.setImageResource(R.drawable.imgrojo)
                    jugador1win = true
                }
            }
        }
        //Diagonal principal
        if(binding.tv1.text.equals("X")){
            if(binding.tv5.text.equals("X")){
                if(binding.tv9.text.equals("X")){
                    //Ganó, pintar esas celdas de color verde y lo demás en rojo :]
                    binding.imageButton1.setImageResource(R.drawable.imgverde)
                    binding.imageButton5.setImageResource(R.drawable.imgverde)
                    binding.imageButton9.setImageResource(R.drawable.imgverde)
                    //Rojo
                    binding.imageButton2.setImageResource(R.drawable.imgrojo)
                    binding.imageButton3.setImageResource(R.drawable.imgrojo)
                    binding.imageButton4.setImageResource(R.drawable.imgrojo)
                    binding.imageButton6.setImageResource(R.drawable.imgrojo)
                    binding.imageButton7.setImageResource(R.drawable.imgrojo)
                    binding.imageButton8.setImageResource(R.drawable.imgrojo)
                    jugador1win = true
                }
            }
        }
        //Diagonal secundaria
        if(binding.tv3.text.equals("X")){
            if(binding.tv5.text.equals("X")){
                if(binding.tv7.text.equals("X")){
                    //Ganó, pintar esas celdas de color verde y lo demás en rojo :]
                    binding.imageButton3.setImageResource(R.drawable.imgverde)
                    binding.imageButton5.setImageResource(R.drawable.imgverde)
                    binding.imageButton7.setImageResource(R.drawable.imgverde)
                    //Rojo
                    binding.imageButton1.setImageResource(R.drawable.imgrojo)
                    binding.imageButton2.setImageResource(R.drawable.imgrojo)
                    binding.imageButton4.setImageResource(R.drawable.imgrojo)
                    binding.imageButton6.setImageResource(R.drawable.imgrojo)
                    binding.imageButton8.setImageResource(R.drawable.imgrojo)
                    binding.imageButton9.setImageResource(R.drawable.imgrojo)
                    jugador1win = true
                }
            }
        }




        //ahora comprobamos todo lo del jugador O (2, par).
        //Eje recto de la primera fila -->
        if(binding.tv1.text.equals("O")){
            if(binding.tv2.text.equals("O")){
                if(binding.tv3.text.equals("O")){
                    //Ganó, pintar esas celdas de color verde y lo demás en rojo :]
                    binding.imageButton1.setImageResource(R.drawable.imgverde)
                    binding.imageButton2.setImageResource(R.drawable.imgverde)
                    binding.imageButton3.setImageResource(R.drawable.imgverde)
                    //Rojo
                    binding.imageButton4.setImageResource(R.drawable.imgrojo)
                    binding.imageButton5.setImageResource(R.drawable.imgrojo)
                    binding.imageButton6.setImageResource(R.drawable.imgrojo)
                    binding.imageButton7.setImageResource(R.drawable.imgrojo)
                    binding.imageButton8.setImageResource(R.drawable.imgrojo)
                    binding.imageButton9.setImageResource(R.drawable.imgrojo)
                    jugador2win = true
                }
            }
        }
        //Eje recto de la segunda fila -->
        if(binding.tv4.text.equals("O")){
            if(binding.tv5.text.equals("O")){
                if(binding.tv6.text.equals("O")){
                    //Ganó, pintar esas celdas de color verde y lo demás en rojo :]
                    binding.imageButton4.setImageResource(R.drawable.imgverde)
                    binding.imageButton5.setImageResource(R.drawable.imgverde)
                    binding.imageButton6.setImageResource(R.drawable.imgverde)
                    //Rojo
                    binding.imageButton1.setImageResource(R.drawable.imgrojo)
                    binding.imageButton2.setImageResource(R.drawable.imgrojo)
                    binding.imageButton3.setImageResource(R.drawable.imgrojo)
                    binding.imageButton7.setImageResource(R.drawable.imgrojo)
                    binding.imageButton8.setImageResource(R.drawable.imgrojo)
                    binding.imageButton9.setImageResource(R.drawable.imgrojo)
                    jugador2win = true
                }
            }
        }
        //Eje recto de la tercera fila fila -->
        if(binding.tv7.text.equals("O")){
            if(binding.tv8.text.equals("O")){
                if(binding.tv9.text.equals("O")){
                    //Ganó, pintar esas celdas de color verde y lo demás en rojo :]
                    binding.imageButton7.setImageResource(R.drawable.imgverde)
                    binding.imageButton8.setImageResource(R.drawable.imgverde)
                    binding.imageButton9.setImageResource(R.drawable.imgverde)
                    //Rojo
                    binding.imageButton4.setImageResource(R.drawable.imgrojo)
                    binding.imageButton5.setImageResource(R.drawable.imgrojo)
                    binding.imageButton6.setImageResource(R.drawable.imgrojo)
                    binding.imageButton1.setImageResource(R.drawable.imgrojo)
                    binding.imageButton2.setImageResource(R.drawable.imgrojo)
                    binding.imageButton3.setImageResource(R.drawable.imgrojo)
                    jugador2win = true
                }
            }
        }


        //Eje recto de la primera columna ^
        if(binding.tv1.text.equals("O")){
            if(binding.tv4.text.equals("O")){
                if(binding.tv7.text.equals("O")){
                    //Ganó, pintar esas celdas de color verde y lo demás en rojo :]
                    binding.imageButton1.setImageResource(R.drawable.imgverde)
                    binding.imageButton4.setImageResource(R.drawable.imgverde)
                    binding.imageButton7.setImageResource(R.drawable.imgverde)
                    //Rojo
                    binding.imageButton2.setImageResource(R.drawable.imgrojo)
                    binding.imageButton3.setImageResource(R.drawable.imgrojo)
                    binding.imageButton5.setImageResource(R.drawable.imgrojo)
                    binding.imageButton6.setImageResource(R.drawable.imgrojo)
                    binding.imageButton8.setImageResource(R.drawable.imgrojo)
                    binding.imageButton9.setImageResource(R.drawable.imgrojo)
                    jugador2win = true
                }
            }
        }
        //Eje recto de la segunda columna ^
        if(binding.tv2.text.equals("O")){
            if(binding.tv5.text.equals("O")){
                if(binding.tv8.text.equals("O")){
                    //Ganó, pintar esas celdas de color verde y lo demás en rojo :]
                    binding.imageButton2.setImageResource(R.drawable.imgverde)
                    binding.imageButton5.setImageResource(R.drawable.imgverde)
                    binding.imageButton8.setImageResource(R.drawable.imgverde)
                    //Rojo
                    binding.imageButton1.setImageResource(R.drawable.imgrojo)
                    binding.imageButton3.setImageResource(R.drawable.imgrojo)
                    binding.imageButton4.setImageResource(R.drawable.imgrojo)
                    binding.imageButton6.setImageResource(R.drawable.imgrojo)
                    binding.imageButton7.setImageResource(R.drawable.imgrojo)
                    binding.imageButton9.setImageResource(R.drawable.imgrojo)
                    jugador2win = true
                }
            }
        }
        //Eje recto de la tercer columna ^
        if(binding.tv3.text.equals("O")){
            if(binding.tv6.text.equals("O")){
                if(binding.tv9.text.equals("O")){
                    //Ganó, pintar esas celdas de color verde y lo demás en rojo :]
                    binding.imageButton3.setImageResource(R.drawable.imgverde)
                    binding.imageButton6.setImageResource(R.drawable.imgverde)
                    binding.imageButton9.setImageResource(R.drawable.imgverde)
                    //Rojo
                    binding.imageButton1.setImageResource(R.drawable.imgrojo)
                    binding.imageButton2.setImageResource(R.drawable.imgrojo)
                    binding.imageButton4.setImageResource(R.drawable.imgrojo)
                    binding.imageButton5.setImageResource(R.drawable.imgrojo)
                    binding.imageButton7.setImageResource(R.drawable.imgrojo)
                    binding.imageButton8.setImageResource(R.drawable.imgrojo)
                    jugador2win = true
                }
            }
        }
        //Diagonal principal
        if(binding.tv1.text.equals("O")){
            if(binding.tv5.text.equals("O")){
                if(binding.tv9.text.equals("O")){
                    //Ganó, pintar esas celdas de color verde y lo demás en rojo :]
                    binding.imageButton1.setImageResource(R.drawable.imgverde)
                    binding.imageButton5.setImageResource(R.drawable.imgverde)
                    binding.imageButton9.setImageResource(R.drawable.imgverde)
                    //Rojo
                    binding.imageButton2.setImageResource(R.drawable.imgrojo)
                    binding.imageButton3.setImageResource(R.drawable.imgrojo)
                    binding.imageButton4.setImageResource(R.drawable.imgrojo)
                    binding.imageButton6.setImageResource(R.drawable.imgrojo)
                    binding.imageButton7.setImageResource(R.drawable.imgrojo)
                    binding.imageButton8.setImageResource(R.drawable.imgrojo)
                    jugador2win = true
                }
            }
        }
        //Diagonal secundaria
        if(binding.tv3.text.equals("O")){
            if(binding.tv5.text.equals("O")){
                if(binding.tv7.text.equals("O")){
                    //Ganó, pintar esas celdas de color verde y lo demás en rojo :]
                    binding.imageButton3.setImageResource(R.drawable.imgverde)
                    binding.imageButton5.setImageResource(R.drawable.imgverde)
                    binding.imageButton7.setImageResource(R.drawable.imgverde)
                    //Rojo
                    binding.imageButton1.setImageResource(R.drawable.imgrojo)
                    binding.imageButton2.setImageResource(R.drawable.imgrojo)
                    binding.imageButton4.setImageResource(R.drawable.imgrojo)
                    binding.imageButton6.setImageResource(R.drawable.imgrojo)
                    binding.imageButton8.setImageResource(R.drawable.imgrojo)
                    binding.imageButton9.setImageResource(R.drawable.imgrojo)
                    jugador2win = true

                }
            }
        }
 comprobarfinal()


      }
    fun comprobarfinal(){
        //   Creación del intent para ir a la pantalla final.

        val bundle = intent.extras
        val jugador1 = bundle?.get("jugador1")
        val jugador2 = bundle?.get("jugador2")

        val IntentFinal = Intent(this, Final::class.java)



        if(jugador1win || jugador2win){
            IntentFinal.putExtra("jugador11", jugador1.toString())
            IntentFinal.putExtra("jugador22", jugador1.toString())
            victoria = true

            startActivity(IntentFinal)

        } else if(num == 9){
            IntentFinal.putExtra("jugador11", jugador1.toString())
            IntentFinal.putExtra("jugador22", jugador1.toString())
            startActivity(IntentFinal)
        }


    }



}