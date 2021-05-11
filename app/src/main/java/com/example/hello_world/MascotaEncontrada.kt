package com.example.hello_world

import com.google.gson.annotations.Expose
import java.io.Serializable


data class MascotaEncontrada(
    @Expose val tamaño: String,
    @Expose val raza: String,
    @Expose val color: String,
    @Expose val Ubicacion: String,
    @Expose val edad_promedio: String
) :Serializable



