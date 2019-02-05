package com.example.cln62.easymanagement.data.pojo

import android.os.Parcel
import android.os.Parcelable

data class SignupInfo (
    var fname: String,
    var lname: String,
    var email: String,
    var mobile: String,
    var password: String,
    var compSize: String,
    var role: String
) : Parcelable {
    constructor(source: Parcel) : this(
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(fname)
        writeString(lname)
        writeString(email)
        writeString(mobile)
        writeString(password)
        writeString(compSize)
        writeString(role)
    }

    override fun toString(): String {
        return "Register(fname='$fname', lname='$lname', email='$email', mobile='$mobile', pass='$password', compSize='$compSize', role='$role')"
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<SignupInfo> = object : Parcelable.Creator<SignupInfo> {
            override fun createFromParcel(source: Parcel): SignupInfo = SignupInfo(source)
            override fun newArray(size: Int): Array<SignupInfo?> = arrayOfNulls(size)
        }
    }
}