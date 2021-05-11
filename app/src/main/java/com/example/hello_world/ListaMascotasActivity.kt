package com.example.hello_world

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_lista_mascotas2.*

class ListaMascotasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_mascotas2)

        recyclerViewMascotas.adapter = ProductListRecyclerViewAdapter(mascotaAguardar)
        recyclerViewMascotas.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}