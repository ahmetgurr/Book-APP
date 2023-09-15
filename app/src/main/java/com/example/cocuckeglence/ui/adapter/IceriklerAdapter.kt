package com.example.cocuckeglence.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.cocuckeglence.R
import com.example.cocuckeglence.ui.view.TanitimActivity
import com.example.cocuckeglence.data.entity.Icerikler

class IceriklerAdapter(private val mContext: Context,
                       private val iceriklerListe: List<Icerikler>)
                      : RecyclerView.Adapter<IceriklerAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(tasarim:View):RecyclerView.ViewHolder(tasarim){
//asağıda eşitlediklerimiz nereden geldiklerini tanıtıyor icerik_card ın cardviewdan geldiğini  mesela.
        var icerik_card: CardView
        var textViewIcerikAd: TextView
        var imageViewIcerikResim: ImageView

        init {
            icerik_card = tasarim.findViewById(R.id.icerik_card)
            textViewIcerikAd = tasarim.findViewById(R.id.textViewIcerikAd)
            imageViewIcerikResim = tasarim.findViewById(R.id.imageViewIcerikResim)
        }

    }
    //Inflater - LayoutInflater - MenuInflater-- xml ile kodu ne zaman baglamak istersek bunları kullanırız.
    //.inflate(R.layout.icerl_card_tasarim)-- inflate yazarken nereyi bağlamak istiyorsun anlamına gelir.
    //, koyduktan parent istyor--> ViewGrup veriliyor zaten-> nerde calıstıgını soruyor o da parent
    // attachtherootu soruyor yanı roota bagalayaım mı soruyor boş bir soru false yaz geç.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val tasarim = LayoutInflater.from(mContext).inflate(R.layout.icerik_card_tasarim,parent,false)
        return CardTasarimTutucu(tasarim)//bu fonksiyon CardTasarimTutucu'yu doındurmemızı istiyordu  () içinde ise bir gorunum ıstıyordu o da olusturdugumuz gorunumu verıyoruz brı ust satırda =  tasarım
    }
    //birkaç tane row olusturacagımızı soyledık
    override fun getItemCount(): Int {
        return iceriklerListe.size
    }

    //onBindViewHolder en son yazılır burdakı amac CardTasarimTutucunun ıcındeki her şeyi holder ile çekebiliyoruz.
    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val icerik = iceriklerListe.get(position)
        holder.textViewIcerikAd.text = icerik.Icerik_ad //textin  içeriğindeki adı Icerikler classımızın içindeki Icerik_ad' a eşitliyoruz
        holder.imageViewIcerikResim.setImageResource(mContext.resources.getIdentifier(icerik.Icerik_resim,"drawable",mContext.packageName)) //alttaki kodda resimlerin bulundugu kalsorden resimleri çekiyor
        //icerk_card'a tıklanma ozelliği veriyoruz
        holder.icerik_card.setOnClickListener{
            val intent = Intent(mContext, TanitimActivity::class.java)
            intent.putExtra("masalKitabiIcerik",icerik)
            //intent.putExtra("kategoriNesne",kategori)//veriyi diğer sayfaya göndermeye yarıyor
            mContext.startActivity(intent)

        }
    }


}