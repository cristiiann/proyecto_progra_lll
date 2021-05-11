package com.example.hello_world

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.annotations.Expose
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_registro_perdida.*
import java.io.Serializable

class AddPerdidaActivity : AppCompatActivity() {

    private var fileUri: Uri? = null
    private val requestCodeGallery = 123

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_perdida)

        buttonGallery.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_PICK
            intent.type = "image/*"
            startActivityForResult(
                Intent.createChooser(intent, " Subir imagen"),
                requestCodeGallery
            )

        }

        buttonPublicar.setOnClickListener {
            val newRegistroPerdida = RegistroPerdida(
                fileUri,
                editTextTamano.text.toString(),
                editTextColor.text.toString(),
                editTextCelular.text.toString(),
                editTextDueno.text.toString(),
                editTextDepartamento.text.toString(),
                editTextUltimaUbicacion.text.toString()
            )
            RegistroPerdidaTemporal.AddPerdidaActivity.add(newRegistroPerdida)
            finish()
        }

        fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)
            if (requestCode == requestCodeGallery) {
                imageView.setImageURI(data?.data)
                fileUri = data?.data
            }
        }

    }
}

    data class RegistroPerdida(
        @Expose val Image: Uri?,
        @Expose val Tamano: String,
        @Expose val Color: String,
        @Expose val Celular: String,
        @Expose val Dueno: String,
        @Expose val Departamento: String,
        @Expose val UltimaUbicacion: String
    )



