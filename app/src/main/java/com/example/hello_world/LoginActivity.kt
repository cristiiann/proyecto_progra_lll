package com.example.hello_world
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_crear_cuenta.*
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {

    val sharedPreferencesManager= SharedPreferencesManager()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        button_IniciarSesion.setOnClickListener {

            val username = editTextTextEmailAddress.text.toString()
            val password = editTextTextPassword.text.toString()


        val validUsers = sharedPreferencesManager.obtenerUsuarios(this)
            for(validUser in validUsers){
                if(validUser.username == username && validUser.password == password) {
                    sharedPreferencesManager.guardarUsuarioInicioSesion(this,validUser)
                    TemporalStorage.usuario = validUser
                    val intent = Intent(this, OptionsActivity::class.java)
                    intent.putExtra("username", username)
                    intent.putExtra("password", password)
                    startActivity(intent)
                    break
            } else {
                    Toast.makeText(this, "Login Incorrecto", Toast.LENGTH_SHORT).show()
                }
        }
        progressBar.visibility = View.VISIBLE


            Handler(Looper.getMainLooper()).postDelayed({
                progressBarInicio.progress = 33
            }, 1000)

            Handler(Looper.getMainLooper()).postDelayed({
                progressBarInicio.progress = 67
            }, 2000)

            Handler(Looper.getMainLooper()).postDelayed({
                progressBarInicio.progress = 100
            }, 3000)

    }
        val usuarioInicioSesion = sharedPreferencesManager.obtenerUsuarioInicioSesion(this)
        if (usuarioInicioSesion != null){
            TemporalStorage.usuario = usuarioInicioSesion
            val intent = Intent(this, OptionsActivity::class.java)
            intent.putExtra("username", usuarioInicioSesion.username)
            intent.putExtra("password", usuarioInicioSesion.password)
            startActivity(intent)
        }

        CrearCuentaNuevabutton.setOnClickListener {
            val intent = Intent (this, CrearCuentaActivity::class.java)
            startActivity(intent)
        }
    }
}

data class Usuario( val username: String, val password: String)