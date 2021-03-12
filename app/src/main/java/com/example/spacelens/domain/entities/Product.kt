package com.example.spacelens.domain.entities

import android.os.Parcel
import android.os.Parcelable

data class Product (
    val product_id: Long,
    val title: String?,
    val description: String?,
    val price: Double,
    val attachment: Attachment,
    val gallery: List<ImageSource>,
    val location: Location
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readLong(),
        parcel.readString(),
        parcel.readString(),
        parcel.readDouble(),
        parcel.readParcelable(Attachment::class.java.classLoader)!!,
        parcel.createTypedArrayList(ImageSource)!!,
        parcel.readParcelable(Location::class.java.classLoader)!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(product_id)
        parcel.writeString(title)
        parcel.writeString(description)
        parcel.writeDouble(price)
        parcel.writeParcelable(attachment, flags)
        parcel.writeTypedList(gallery)
        parcel.writeParcelable(location, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Product> {
        override fun createFromParcel(parcel: Parcel): Product {
            return Product(parcel)
        }

        override fun newArray(size: Int): Array<Product?> {
            return arrayOfNulls(size)
        }
    }
}