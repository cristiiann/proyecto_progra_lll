package com.example.hello_world
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val validUsersList= listOf(
                Usuario(username = "Daniela", password = "1234"),
                Usuario(username = "Cristian", password = "1234"),
                Usuario(username = "Pablo", password = "1234")
        )
        button_IniciarSesion.setOnClickListener{
            val username = editTextTextEmailAddress.text.toString()
            val password = editTextTextPassword.text.toString()

            for (user in validUsersList){
                if (user.username == username && user.password == password){
                    textView.text = "usuario correcto"
                    break
                } else {
                    textView.text ="usuario incorrecto"
                }
            }
            progressBar.visibility = View.VISIBLE

            val intent = Intent (this, OptionsActivity :: class.java)
            startActivity(intent)

            
        }

    }
}

data class Usuario(val username: String, val password: String)