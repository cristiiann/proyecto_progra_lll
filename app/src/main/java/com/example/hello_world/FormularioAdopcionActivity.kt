package com.example.hello_world

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.annotations.Expose
import kotlinx.android.synthetic.main.activity_formulario_adopcion.*
import kotlinx.android.synthetic.main.activity_login.*


class FormularioAdopcionActivity : AppCompatActivity() {

    private var fileUri: Uri? = null
    private val requestCodeGallery = 123

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_adopcion)


        ButtonSubirImagen.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_PICK
            intent.type = "image/*"
            startActivityForResult(
                Intent.createChooser(intent, " Subir Imagen"),
                requestCodeGallery
            )
        }

        buttonAgregarAdopcion.setOnClickListener {
            val newFormularioAdopcion = FormularioAdopcion(
                    fileUri,
                editTextNombre.text.toString(), editTextCiudad.text.toString(), editTextSalud.text.toString(), editTextPersonalidad.text.toString(), editTextEdad.text.toString())
            FormularioAdopcionTemporal.AddAdopcionActivity.add(newFormularioAdopcion)
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
    data class FormularioAdopcion(
            @Expose val Image : Uri?,
            @Expose val Nombre: String,
            @Expose val Ciudad: String,
            @Expose val Salud: String,
            @Expose val Personalidad: String,
            @Expose val Edad: String
    )

