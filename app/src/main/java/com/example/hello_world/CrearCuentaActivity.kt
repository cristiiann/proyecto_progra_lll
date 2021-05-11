package com.example.hello_world

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.google.gson.annotations.Expose
import kotlinx.android.synthetic.main.activity_crear_cuenta.*
import java.io.Serializable

class CrearCuentaActivity : AppCompatActivity() {

    val sharedPreferencesManager = SharedPreferencesManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_cuenta)

        val citiesList= listOf("Selecciona la ciudad","Cochabamba","La Paz","Santa Cruz")
        spinnerCiudades.adapter =ArrayAdapter(this, android.R.layout.simple_list_item_1, citiesList)
        spinnerCiudades.selectedItem


        AbrirCuentabutton.setOnClickListener{
            val usuarioAGuardar = NuevoUsuario(NombresText.text.toString(), ApellidosText.text.toString() ,IngresarNombreUsuarioText.text.toString(),IngresePasswordText.text.toString())
            sharedPreferencesManager.crearUsuarioNuevo(this, usuarioAGuardar)
            finish()

            val intent = Intent (this, LoginActivity::class.java)
            startActivity(intent)
                }
            }

}
 data class NuevoUsuario(@Expose val nombres: String, @Expose val apellidos: String, @Expose val username: String, @Expose val password: String):Serializable
