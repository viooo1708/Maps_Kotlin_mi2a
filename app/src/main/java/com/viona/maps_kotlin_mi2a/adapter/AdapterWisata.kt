package com.viona.maps_zukira.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.viona.maps_kotlin_mi2a.DetailWisataMapsActivity
import com.viona.maps_kotlin_mi2a.R
import com.viona.maps_kotlin_mi2a.model.ModelWisata

class AdapterWisata(
    //data diambil dari model
    val listItemWisata: List<ModelWisata>

) : RecyclerView.Adapter<AdapterWisata.MyViewHolder>() {
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        //layout pada widget
        val imgWisata: ImageView = itemView.findViewById(R.id.imgWisata)
        val tvNamaTempatWisata: TextView = itemView.findViewById(R.id.tvNamaTempatWisata)
        val tvAlamat: TextView = itemView.findViewById(R.id.tvAlamat)
        val cardWisata: CardView = itemView.findViewById(R.id.cardWisata)

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

        //event klil pada cardview
        holder.cardWisata.setOnClickListener {
            val intentDetailWisata = Intent(holder.itemView.context, DetailWisataMapsActivity::class.java)
            //kirim data item list wisata ke DetailWisataMapsActivity
            intentDetailWisata.putExtra("namaLokasiWisata",currentItem.namaLokasiWisata)
            intentDetailWisata.putExtra("gambarWisata",currentItem.gambarWisata)
            intentDetailWisata.putExtra("deskripsiWisata",currentItem.deskripsiWisata)
            intentDetailWisata.putExtra("latWisata",currentItem.latWisata)
            intentDetailWisata.putExtra("longWisata",currentItem.longWisata)

            //menjalankan intent startActivity
            holder.itemView.context.startActivity(intentDetailWisata)
        }

    }

    override fun getItemCount(): Int {
        return listItemWisata.size
    }
}