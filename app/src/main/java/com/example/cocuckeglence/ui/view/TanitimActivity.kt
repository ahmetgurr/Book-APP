package com.example.cocuckeglence.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.cocuckeglence.R
import com.example.cocuckeglence.data.entity.Icerikler
import com.example.cocuckeglence.databinding.ActivityTanitimBinding

class TanitimActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTanitimBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTanitimBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //"masalKitabiIcerik" yazısını IcerikAdapterdan aldık ordaki baslıgı atıyor.
        val kategoriIcerikDetay = intent.getSerializableExtra("masalKitabiIcerik") as Icerikler
        //kategori baslıklarını içeriğe cekme
        binding.toolbarMasalBaslik.title = " ${kategoriIcerikDetay.Icerik_ad}"
        setSupportActionBar(binding.toolbarMasalBaslik)


/*
       val intent = intent
       val secilenMasalIsmi = intent.getStringExtra("masalKitabiIcerik")
        textView.text = secilenMasalIsmi
****************************************
        val intent = intent
        if (intent.hasExtra("masalKitabiIcerik")) {
            val metin = intent.getStringExtra("masalKitabiIcerik")

            // Metni kullanabilirsiniz
            // Örnek: Bir TextView'e metini yerleştirme
            val textView = findViewById<TextView>(R.id.textViewTanitimBaslik)
            textView.text = metin
        }

 */
        // Intent'ten veriyi alıp text içine yazdırır.
        val gelenIntent = intent
        if (gelenIntent.hasExtra("masalKitabiIcerik")) {
            val icerik = gelenIntent.getSerializableExtra("masalKitabiIcerik") as Icerikler // Icerik sınıfının türüne dikkat edin
            val icerikAd = icerik.Icerik_ad

            // TextView içine veriyi yerleştirme
            val textViewTanitimBaslik = findViewById<TextView>(R.id.textViewTanitimBaslik)
            textViewTanitimBaslik.text = icerikAd
        }




    }
}