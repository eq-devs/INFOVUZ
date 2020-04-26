package com.demo.infovuz.models

import android.os.Parcelable
import com.google.firebase.database.IgnoreExtraProperties

import kotlinx.android.parcel.Parcelize
import java.security.Timestamp

@Parcelize
@IgnoreExtraProperties
data class Info(
    var id: String = "",
    var name: String="",
    var image :String="",
    var timestamp: String="",
    val discriptin:String="",
    val phone:String="",
    val email:String="",
    val facebook:String="",
    val instagram:String="",
    val address:String="",
    var check :Boolean?=null
) : Parcelable {

}

/*


constructor()

constructor(_id: String = "",_name: String = "",_image: String = "",_timestamp: String = "",
_discriptin: String = "" , _phone: String = "",
_email: String = "", _facebook: String = "",
_instagram: String = "", _address: String = ""
) {
    this.id = _id
    this.name = _name
    this.image = _image
    this.timestamp = _timestamp
    this.discriptin = _discriptin
    this.phone = _phone
    this.email = _email
    this.facebook = _facebook
    this.instagram = _instagram
    this.address = _address

}*/
