package com.example.cocuckeglence

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.cocuckeglence.data.entity.IcerikDetay
import com.example.cocuckeglence.data.entity.Icerikler
import com.example.cocuckeglence.data.entity.Kategoriler
import com.example.cocuckeglence.databinding.ActivityIcerikBinding

class IcerikActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIcerikBinding
    private lateinit var icerikListe:ArrayList<Icerikler>
    private lateinit var adapter: IceriklerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIcerikBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val kategori = intent.getSerializableExtra("kategoriNesne") as Kategoriler//getSerializableExtra-->aktiviteler arası veir almak için kullanılır


        //kategori baslıklarını içeriğe cekme
        binding.toolbarIcerikler.title = " ${kategori.kategori_ad}"
        setSupportActionBar(binding.toolbarIcerikler)

        binding.iceriklerRv.setHasFixedSize(true)//recyclerview ile liste tablo gorunumu olsuturdugumuzda boyut degismeyecekse performans arttırmak ıcın kullanılır
        //alttaki kod blogu icerklerimizin alt alta değilde yan yana ve kaçarlı oalcak şekilde dıkey yatay oalcagını yazıyoruz 2,Vertical şeklinde
        binding.iceriklerRv.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)


        icerikListe = ArrayList()

        val k = Kategoriler(1,"Masal")
        val y = IcerikDetay(2,"Keloğlan")

        val c1 = Icerikler(1,"Prens","prens","masal1prens",k,y)
        val c2 = Icerikler(2,"Rapunzel","rapunzel","masal2rapunzel",k,y)
        val c3 = Icerikler(3,"Pinokyo","pinokyo","masal3pinokyo",k,y)
        val c4 = Icerikler(4,"Kurt","kurt","masal4kurt",k,y)
        val c5 = Icerikler(5,"Uzgunordek","uzgunordek","masal5uzgunordek",k,y)
        val c6 = Icerikler(6,"Kus","kus","masal6kus",k,y)

        icerikListe.add(c1)
        icerikListe.add(c2)
        icerikListe.add(c3)
        icerikListe.add(c4)
        icerikListe.add(c5)
        icerikListe.add(c6)

        adapter = IceriklerAdapter(this,icerikListe)

        binding.iceriklerRv.adapter = adapter
    }
}