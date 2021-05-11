package com.example.hello_world

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.formularioencontrar_main.*

class FormularioencontrarActivity : AppCompatActivity() {

    val sharedPreferencesManager = PabloSharedPreferencesManager ()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.formularioencontrar_main)

        buttonPublicar.setOnClickListener {
            val mascotaAguardar = MascotaEncontrada(editTextTamaño.text.toString(),editTextRaza.text.toString(),editTextColor.text.toString(),
                editTextUbicacion.text.toString(), editTextEdadPromedio.text.toString())

            sharedPreferencesManager.crearMascotaNuevo(this, mascotaAguardar)
            finish()
        }
    }
}