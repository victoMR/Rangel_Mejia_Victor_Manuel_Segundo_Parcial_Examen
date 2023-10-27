package com.example.rngelmejiavictormanuelsegundoparcialexamen

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    //atributos
    private lateinit var tvMensaje1: TextView
    private lateinit var etMensaje1: EditText
    private lateinit var spinnerCarros: Spinner
    private lateinit var btnCalcular: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //inicializar atributos
        tvMensaje1 = findViewById(R.id.tvMensaje1)
        etMensaje1 = findViewById(R.id.etMensaje1)
        spinnerCarros = findViewById(R.id.spinnerCarros)
        btnCalcular = findViewById(R.id.btnCalcular)


        //Calcular el monto de renta de un vehículo porn km y marca de vehículo
        // declaramos el arreglo con las marcas de celulares desde el xml con los valores
        val marcasCarrosAdap = ArrayAdapter.createFromResource(
            this,
            R.array.marcasCoches,
            android.R.layout.simple_spinner_item
        )

        //declaramos el adaptador
        marcasCarrosAdap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCarros.adapter = marcasCarrosAdap


        // evento click del botón
        btnCalcular.setOnClickListener {

            //logica de el spinner de marcas de celulares del xml
            btnCalcular.setOnClickListener {

                //logica de el spinner de marcas de celulares del xml
                spinnerCarros.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        if (position == 0) {
                            tvMensaje1.text = ""
                        } else {
                            val marcaSeleccionada = parent.getItemAtPosition(position).toString()
                            tvMensaje1.text = "La marca seleccionada es: $marcaSeleccionada"
                        }
                    }

                    override fun onNothingSelected(parent: AdapterView<*>) {
                        tvMensaje1.text = "No seleccionaste nada 🥺"
                    }
                }

                // crear el intent
                val intent = Intent(this@MainActivity, MainActivity2::class.java)

                //Calcular el monto de renta de un vehículo porn km y marca de vehículo
                // SI ES NISSAN SON 25 SI ES KIA ES 35 Y SI ES BMW ES 70
                val marca = spinnerCarros.selectedItem.toString()
                val km = etMensaje1.text.toString()
                intent.putExtra("km", km)
                intent.putExtra("marca", marca)

                if (marca == null) {
                    // mostrar mensaje
                    etMensaje1.error = "Debe ingresar una marca "
                    // salir de la función
                    return@setOnClickListener
                }

                // iniciar la nueva actividad
                startActivity(intent)
            }

        }
    }
}