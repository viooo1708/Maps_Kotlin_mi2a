package com.viona.maps_kotlin_mi2a

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.viona.maps_kotlin_mi2a.R
import com.viona.maps_kotlin_mi2a.databinding.ActivityDetailWisataMapsBinding


class DetailWisataMapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityDetailWisataMapsBinding

    private lateinit var tvNamaLokasiWisata: TextView
    private lateinit var imgWisata: ImageView
    private lateinit var tvDeskripsi: TextView
    private lateinit var btnLokasi: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailWisataMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        tvNamaLokasiWisata = findViewById(R.id.tvNamaLokasiWisata)
        imgWisata = findViewById(R.id.imgWisata)
        tvDeskripsi = findViewById(R.id.tvDeskripsi)
        btnLokasi = findViewById(R.id.btnLokasi)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.Map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        //mengambil data dari intent
        val namaLokasiWisata = intent.getStringExtra("namaLokasiWisata")
        val gambarWisata = intent.getIntExtra("gambarWisata",0)
        val deskripsiWisata = intent.getStringExtra("deskripsiWisata")
        val latWisata = intent.getDoubleExtra("latWisata",0.0)
        val longWisata = intent.getDoubleExtra("longWisata",0.0)

        tvNamaLokasiWisata.text = namaLokasiWisata
        imgWisata.setImageResource(gambarWisata)
        tvDeskripsi.text = deskripsiWisata

        //event click button Map Wisata
        btnLokasi.setOnClickListener {
            val intentMapWisata = Intent(this,MapsWisataActivity::class.java)
            //kirim lat dan long
            intentMapWisata.putExtra("latWisata",latWisata)
            intentMapWisata.putExtra("longWisata",longWisata)
            intentMapWisata.putExtra("namaLokasiWisata",namaLokasiWisata)
            startActivity(intentMapWisata)
        }


        // Add a marker in Sydney and move the camera
        val koordinatWisata = LatLng(-latWisata, longWisata)
        mMap.addMarker(MarkerOptions().position(koordinatWisata).title(namaLokasiWisata))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(koordinatWisata))
    }
}