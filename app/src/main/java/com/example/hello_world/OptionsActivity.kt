package com.example.hello_world

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.options_main.*
import kotlin.math.truncate


class OptionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.options_main)

        val sharedPreferencesManager = SharedPreferencesManager()

        val usernameRecibido = intent.getStringExtra("username")
        val passwordRecibido = intent.getStringExtra("password")


//        val user = intent.getSerializableExtra("user") as Usuario
        val user = TemporalStorage.usuario!!


        toolbar.title = "Bienvenido " + user.username

        toolbar.setOnMenuItemClickListener { menuItem ->
            when(menuItem.itemId) {
                R.id.menuItemCerrarSesion -> {
                    sharedPreferencesManager.borrarUsuarioInicioSesion(this)
                    finish()
                }
            }
            true
        }

        buttonAdopta.setOnClickListener{
            val intent = Intent (this, FormularioAdopcionActivity::class.java)
            startActivity(intent)
        }

        buttonEncontreUnaMacota.setOnClickListener{
            val intent = Intent (this, FormularioEncontreUnaMascotaActivity::class.java)
            startActivity(intent)
        }

        buttonSePerdioMiMascota.setOnClickListener{
            val intent = Intent (this, FormularioSePerdioMiMascotaActivity::class.java)
            startActivity(intent)
        }
    }
}

