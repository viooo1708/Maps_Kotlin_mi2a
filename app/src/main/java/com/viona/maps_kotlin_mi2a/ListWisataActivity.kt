package com.viona.maps_kotlin_mi2a

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.viona.maps_kotlin_mi2a.adapter.AdapterWisata
import com.viona.maps_kotlin_mi2a.model.ModelWisata

class ListWisataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_wisata)

        //data list wisata
        val listWisata = listOf<ModelWisata>(
            ModelWisata("Lokasi1", "Alamat1", R.drawable.destinasi_wisata1, "Deskripsi1", -0.9288850297894812, 100.34995652713918),
            ModelWisata("Lokasi2", "Alamat2", R.drawable.destinasi_wisata2, "Deskripsi2", -0.30499781943540566, 100.3695201455013),
            ModelWisata("Lokasi3", "Alamat3", R.drawable.destinasi_wisata3, "Deskripsi3", -0.2792448448039817, 100.37404400871505),
            ModelWisata("Lokasi4", "Alamat4", R.drawable.destinasi_wisata4, "Deskripsi4", -0.1088161761192141, 100.66495717522128),
            ModelWisata("Lokasi5", "Alamat5", R.drawable.destinasi_wisata5, "Deskripsi5", -0.10863975359666288, 100.67125628367117)
        )

        //panggil Adapter
        val adapterWisata = AdapterWisata(listWisata)
        //Recycle view
        val rvWisata: RecyclerView = findViewById(R.id.rvWisata)
        rvWisata.adapter = adapterWisata
        //set layout untuk recycle view
        rvWisata.apply {
            layoutManager = LinearLayoutManager(this@ListWisataActivity)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}