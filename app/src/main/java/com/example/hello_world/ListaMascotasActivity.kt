package com.example.hello_world

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_lista_mascotas2.*
import kotlinx.android.synthetic.main.options_main.*

class ListaMascotasActivity : AppCompatActivity() {
    val sharedPreferences = PabloSharedPreferencesManager ()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_mascotas2)


        Mascotas.adapter = ProductListRecyclerViewAdapter(sharedPreferences.ObtenerMascotas(this))
        Mascotas.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}

