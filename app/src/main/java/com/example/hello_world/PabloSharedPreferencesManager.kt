package com.example.hello_world

import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.google.gson.Gson


class PabloSharedPreferencesManager {
    fun crearMascotaNuevo(context: Context, mascota: MascotaEncontrada) {
        val mascotasRegistradas = ObtenerMascotas(context).toMutableList()
        mascotasRegistradas.add(mascota)
        val mascotasRegistradasJson = Gson().toJson(mascotasRegistradas)
        val prefs = context.getSharedPreferences("datosMascotas", MODE_PRIVATE)
        val prefsEditor = prefs.edit()
        prefsEditor.putString("mascotas", mascotasRegistradasJson)
        prefsEditor.apply()
    }

    fun ObtenerMascotas(context: Context): List<MascotaEncontrada> {
        val prefs = context.getSharedPreferences("datosMascotas", MODE_PRIVATE)
        val mascotaJson = prefs.getString("mascotas", null)
        if (mascotaJson != null) {
            val mascotas: List<MascotaEncontrada> = Gson().fromJson(mascotaJson)
            return mascotas
        } else {
            return listOf()
        }
    }
}