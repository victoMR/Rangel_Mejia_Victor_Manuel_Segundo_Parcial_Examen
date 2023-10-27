package com.example.rngelmejiavictormanuelsegundoparcialexamen

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    // atributos
    private lateinit var tvTotal : TextView
    private lateinit var btnVolver : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // inicializar attivutos
        tvTotal = findViewById(R.id.tvTotal)
        btnVolver = findViewById(R.id.btnVolver)

        //Calcular el monto de renta de un vehículo porn km y marca de vehículo
        // SI ES NISSAN SON 25 SI ES KIA ES 35 Y SI ES BMW ES 70

        //obtener los extras
        val km = intent.getStringExtra("km")
        val marca = intent.getStringExtra("marca")
        val kmInt = km?.toIntOrNull()

        if (kmInt != null && marca != null) {
            val costo = when(marca) {
                "Nissan" -> 25 * kmInt
                "Kia" -> 35 * kmInt
                "BMW" -> 70 * kmInt
                else -> null
            }
            if (costo != null) {
                // mostrar el costo
                tvTotal.text = "El costo es: $$costo"
            } else {
                // mostrar un mensaje de error
                tvTotal.text = "Debe ingresar una marca de vehículo válida."
            }
        } else {
            if (km == null) {
                tvTotal.text = "Por favor, introduce un número válido de kilómetros."
            } else {
                tvTotal.text = "Debe ingresar una marca de vehículo válida."
            }
        }


        // evento click del botón de volver
        btnVolver.setOnClickListener {
            // finalizar la actividad
            finish()
        }

    }


}