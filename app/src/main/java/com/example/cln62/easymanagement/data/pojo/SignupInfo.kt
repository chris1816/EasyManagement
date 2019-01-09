package com.example.cln62.easymanagement.data.pojo

import android.os.Parcel
import android.os.Parcelable

data class SignupInfo(
    var fname: String,
    var lname: String,
    var email: String,
    var mobile: String,
    var password: String,
    var compSize: String,
    var role: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()) {
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(fname)
        parcel.writeString(lname)
        parcel.writeString(email)
        parcel.writeString(mobile)
        parcel.writeString(password)
        parcel.writeString(compSize)
        parcel.writeString(role)
    }

    companion object CREATOR : Parcelable.Creator<SignupInfo> {
        override fun createFromParcel(parcel: Parcel): SignupInfo {
            return SignupInfo(parcel)
        }

        override fun newArray(size: Int): Array<SignupInfo?> {
            return arrayOfNulls(size)
        }
    }
}