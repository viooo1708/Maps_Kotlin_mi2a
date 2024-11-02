package com.viona.maps_kotlin_mi2a.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.viona.maps_kotlin_mi2a.R
import com.viona.maps_kotlin_mi2a.model.ModelWisata
import kotlinx.coroutines.NonDisposableHandle.parent

class AdapterWisata(
    //data di ambil dari model
    val listItemWisata: List<ModelWisata>
) : RecyclerView.Adapter<AdapterWisata.MyViewHolder>() {
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        //layout pada widget//
        val imgWisata: ImageView = itemView.findViewById(R.id.imgWisata)
        val tvNamaTempatWisata: TextView = itemView.findViewById(R.id.tvNamaTempatWisata)
        val tvAlamat: TextView = itemView.findViewById(R.id.tvAlamat)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val nView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_liat_wisata,parent,false)
        return MyViewHolder(nView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       val currentItem = listItemWisata[position]
        holder.imgWisata.setImageResource(currentItem.gambarWisata)
        holder.tvNamaTempatWisata.text = currentItem.namaLokasiWisata
        holder.tvAlamat.text = currentItem.alamatWisata
    }

    override fun getItemCount(): Int {
        return listItemWisata.size
    }
}