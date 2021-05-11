package com.example.hello_world

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.options_main.*


class OptionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.options_main)

        buttonAdopta.text = "Adopta mascotas"
        buttonAdopta.setOnClickListener{
            val intent = Intent (this, FormularioAdopcionActivity::class.java)
            startActivity(intent)
        }

        buttonEncontre.text = "Encontre un perrito"
        buttonEncontre.setOnClickListener{
            val intent = Intent (this, FormularioencontrarActivity::class.java)
            startActivity(intent)
        }




    }

}