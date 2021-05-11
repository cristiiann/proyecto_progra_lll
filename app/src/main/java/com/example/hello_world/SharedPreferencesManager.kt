package com.example.hello_world

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.net.Uri
import com.google.gson.Gson
import com.google.gson.GsonBuilder


class SharedPreferencesManager {
    val gson = GsonBuilder().registerTypeAdapter(Uri::class.java, UriAdapter()).create()

    fun crearUsuarioNuevo(context: Context, usuario: NuevoUsuario){
        val usuarioExistente = obtenerUsuarios(context).find { usuarioRegistrado -> usuarioRegistrado.username == usuario.username }

        if (usuarioExistente == null) {
            val usuariosRegistrados =  obtenerUsuarios(context).toMutableList()
            usuariosRegistrados.add(usuario)

            val usuarioRegistradosJson = gson.toJson(usuariosRegistrados)

            val prefs= context.getSharedPreferences("datos", MODE_PRIVATE)
            val prefsEditor = prefs.edit()
            prefsEditor.putString("usuarios", usuarioRegistradosJson)
            prefsEditor.apply()
        }
    }

    fun obtenerUsuarios(context: Context): List<NuevoUsuario> {
        val prefs = context.getSharedPreferences("datos", MODE_PRIVATE)
        val usuarioJson = prefs.getString("usuarios",null)
        if (usuarioJson != null) {
            val usuarios : List<NuevoUsuario> = gson.fromJson(usuarioJson)
            return usuarios
        } else{
            return listOf()
        }
    }

    fun guardarUsuarioInicioSesion(context: Context, usuario: NuevoUsuario) {
        val usuarioJson = gson.toJson(usuario)
        val prefs = context.getSharedPreferences("datos", MODE_PRIVATE)
        val prefsEditor = prefs.edit()
        prefsEditor.putString("usuarioInicioSesion", usuarioJson)
        prefsEditor.apply()
    }

    fun obtenerUsuarioInicioSesion(context: Context): NuevoUsuario? {
        val prefs = context.getSharedPreferences("datos", MODE_PRIVATE)
        val usuarioJson = prefs.getString("usuarioInicioSesion", null)
        if(usuarioJson != null) {
            val usuario = gson.fromJson(usuarioJson, NuevoUsuario::class.java)
            return usuario
        } else {
            return null
        }
    }

    fun borrarUsuarioInicioSesion(context: Context){
        val prefs= context.getSharedPreferences("datos", MODE_PRIVATE)
        val prefsEditor = prefs.edit()
        prefsEditor.remove("usuarioInicioSesion")
        prefsEditor.apply()
    }
}

