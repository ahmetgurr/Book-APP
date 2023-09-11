package com.example.cocuckeglence

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.cocuckeglence.data.entity.Kategoriler

class KategorilerAdapter(private val mContext: Context,
                         val kategoriList: List<Kategoriler>)
//bir alttakis atırı ekledikten sonra KategorilerAdapteri implement etmemizi istiyor
//onCreateViewHolder / getItemCount / onBindViewHolder kednisi ekliyor bunları
    : RecyclerView.Adapter<KategorilerAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(tasarim:View) : RecyclerView.ViewHolder(tasarim){
        //activity main xml'deki  kategori_card ile textViewKategoriAd'i temsil eder
        var kategori_card: CardView
        var textViewKategoriAd:TextView
        init {
            kategori_card = tasarim.findViewById(R.id.kategori_card)
            textViewKategoriAd = tasarim.findViewById(R.id.textViewKategoriAd)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        //false eklememizin sebebi başka bir şey eklemeyeceğimizi b elirtmek
        val tasarim = LayoutInflater.from(mContext).inflate(R.layout.kategori_card_tasarim,parent,false)//burada tasarim nedir--> LayoutInflaterdan alıp kategori_card_tasarim(recycler_row)ile bagladık.
        //her bir oluşturulan kategori_card_tasarim(recycler_row)'a tasarim (itemView)diyoruz.
        return CardTasarimTutucu(tasarim)
    }

    override fun getItemCount(): Int {
        return kategoriList.size
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val kategori = kategoriList.get(position)

        holder.textViewKategoriAd.text = kategori.kategori_ad
        //tıklanma özelliğini de bir alt satırda verdik
        holder.kategori_card.setOnClickListener{
            // hangi activitye gitmek istiyorsan onu dıyorsun--> IcerikActivity
            val intent = Intent(mContext,IcerikActivity::class.java)
            intent.putExtra("kategoriNesne",kategori)
            //intent.putExtra("kategoriNesne",kategori)//veriyi diğer sayfaya göndermeye yarıyor
            mContext.startActivity(intent)// mContext yazmak yerine itemView.context de ayzarsan çalışır. tasarim kullandıgımız yerlerde itemView kullanabilirdik.
            //holder.itemView.context.startActivity(intent)// bahsettiğim kullanım şekli /  üst satırı silip bunu kullanırsan aynı şekilde çalışır
        }
    }
}