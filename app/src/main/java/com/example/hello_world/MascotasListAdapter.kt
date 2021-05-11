package com.example.hello_world

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView

class ProductListRecyclerViewAdapter(val mascotaAguardar: List<MascotaEncontrada>): RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.list_item_mascotas, parent, false)
        return ViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mascotaAguardar.get(position))
    }

    override fun getItemCount(): Int {
        return mascotaAguardar.size
    }

}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    fun bind(product: MascotaEncontrada){
        itemView.findViewById<TextView>(R.id.textViewRaza).text = product.raza
        itemView.findViewById<TextView>(R.id.textViewTamano).text = product.tamaño
        itemView.findViewById<TextView>(R.id.textViewUbicacion).text = product.Ubicacion
        itemView.findViewById<TextView>(R.id.textViewEdad_promedio).text = product.edad_promedio
        itemView.findViewById<TextView>(R.id.textViewColor).text = product.color
    }

}