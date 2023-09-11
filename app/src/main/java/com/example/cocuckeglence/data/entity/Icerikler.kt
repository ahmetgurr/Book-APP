package com.example.cocuckeglence.data.entity

import com.example.cocuckeglence.data.entity.IcerikDetay
import com.example.cocuckeglence.data.entity.Kategoriler
import java.io.Serializable

data class Icerikler(var Icerik_id:Int,
                     var Icerik_ad:String,
                     var Icerik_isim:String,
                     var Icerik_resim:String,
                     var kategoriler: Kategoriler,
                     var icerikDetay: IcerikDetay
): Serializable {
}