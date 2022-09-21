package com.example.week4

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Api'dan alınan verinin bileşenleri model olarak tanımlandı.
 *
 * @property price
 * @property id
 * @property type
 * @property img_src
 */

@Parcelize
data class MarsModel(
    val price:String,
    val id:String,
    val type:String,
    val img_src:String
):Parcelable
