package com.demo.infovuz.models

import android.os.Parcelable
import com.google.firebase.database.IgnoreExtraProperties

import kotlinx.android.parcel.Parcelize
import java.security.Timestamp

@Parcelize
@IgnoreExtraProperties
class Info(
    var id: String = "",
    var name: String="",
    var image :String="",
    var timestamp: String="",
    val discriptin:String="",
    val phone:String="",
    val email:String="",
    val facebook:String="",
    val instagram:String="",
    val address:String=""
) : Parcelable {}