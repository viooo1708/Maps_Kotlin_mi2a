package com.viona.maps_kotlin_mi2a

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.viona.maps_kotlin_mi2a.model.ModelWisata
import com.viona.maps_zukira.adapter.AdapterWisata

class ListWisataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_wisata)

        //data list wisata
        val listWisata = listOf<ModelWisata>(
            ModelWisata("Wisata Kota Padang", "Kota Padang", R.drawable.destinasi_wisata1, "Pantai padang menyuguhkan keindahan laut yang berlatar belakang perbukitan gunung Padang. Pantai ini berlokasi tak jauh dari pusat kota sehingga Anda hanya perlu mengendarai sebentar untuk mencapai lokasi ini.Pantai padang menyuguhkan keindahan laut yang berlatar belakang perbukitan gunung Padang. Pantai ini berlokasi tak jauh dari pusat kota sehingga Anda hanya perlu mengendarai sebentar untuk mencapai lokasi ini.", -0.9288850297894812, 100.34995652713918),
            ModelWisata("Wisata Jam Gadang", "Bukittinggi", R.drawable.destinasi_wisata2, "Jam Gadang, sebuah ikon yang tak asing di Bukittinggi, Sumatera Barat, telah menjadi saksi bisu perjalanan sejarah kota ini selama hampir satu abad. Menara jam yang menjulang tinggi ini tidak hanya sekadar penunjuk waktu, tetapi juga menjadi objek wisata yang menarik perhatian pengunjung dari berbagai penjuru. Dengan arsitektur uniknya yang menggabungkan unsur lokal dan Eropa, Jam Gadang sering dibandingkan dengan Big Ben London, meskipun memiliki karakteristik tersendiri yang khas.", -0.30499781943540566, 100.3695201455013),
            ModelWisata("Rumah Gadang", "Padang Panjang", R.drawable.destinasi_wisata3, "Rumah Gadang adalah nama untuk rumah adat Minangkabau yang merupakan rumah tradisional dan banyak dijumpai di Sumatera Barat, Indonesia. Rumah ini juga disebut dengan nama lain oleh masyarakat setempat dengan nama Rumah Bagonjong atau ada juga yang menyebut dengan nama Rumah Baanjuang.", -0.2792448448039817, 100.37404400871505),
            ModelWisata("Rumah Gadang Harau", "Payakumbuh", R.drawable.destinasi_wisata4, "Lembah Harau merupakan sebuah ngarai yang berada di Kecamatan Harau, Kabupaten Lima Puluh Kota, Provinsi Sumatera Barat. Destinasi wisata alam ini menyajikan pemandangan sawah dan pepohonan hijau luas yang dikelilingi tebing tinggi. Untuk mencapai kawasan ini, wisatawan harus menempuh perjalanan sejauh 137 kilometer (km) dari pusat Kota Padang atau sekitar 4 jam berkendara. Lamanya perjalanan tersebut akan terbayar lunas dengan pesona Lembah Harau.", -0.1088161761192141, 100.66495717522128),
            ModelWisata("Lembah Harau", "Payakumbuh", R.drawable.destinasi_wisata5, "Lembah Harau adalah sebuah ngarai dekat Kota Payakumbuh di Kabupaten Limapuluh Koto, provinsi Sumatera Barat. Lembah Harau diapit dua bukit cadas terjal dengan ketinggian mencapai 150 meter berupa batu pasir yang terjal berwarna-warni, dengan ketinggian 100 sampai 500 meter. Topografi Cagar Alam Harau adalah berbukit-bukit dan bergelombang. Tinggi dari permukaan laut adalah 500 sampai 850 meter, bukit tersebut antara lain adalah Bukit Air Putih, Bukit Jambu, Bukit Singkarak, dan Bukit Tarantang. Berjalan menuju Lembah Harau amat menyenangkan. Dengan udara yang masih segar, anda bisa melihat keindahan alam sekitarnya. Tebing-tebing granit yang menjulang tinggi dengan bentuknya yang unik mengelilingi lembah. Tebing-tebing granit yang terjal ini mempunyai ketinggian 80 meter hingga 300 meter.", -0.10863975359666288, 100.67125628367117)
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