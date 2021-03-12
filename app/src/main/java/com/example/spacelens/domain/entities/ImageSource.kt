package com.example.spacelens.domain.entities

import android.os.Parcel
import android.os.Parcelable

data class ImageSource(
    val src: String?
): Parcelable {
    constructor(parcel: Parcel) : this(parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(src)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ImageSource> {
        override fun createFromParcel(parcel: Parcel): ImageSource {
            return ImageSource(parcel)
        }

        override fun newArray(size: Int): Array<ImageSource?> {
            return arrayOfNulls(size)
        }
    }
}