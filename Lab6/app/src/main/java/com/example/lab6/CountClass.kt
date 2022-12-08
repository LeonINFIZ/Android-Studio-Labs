package com.example.lab6

import android.os.Parcel
import android.os.Parcelable

data class CountClass(
    val count: Int
): Parcelable {
    constructor(parcel: Parcel) : this(parcel.readInt()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(count)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CountClass> {
        override fun createFromParcel(parcel: Parcel): CountClass {
            return CountClass(parcel)
        }

        override fun newArray(size: Int): Array<CountClass?> {
            return arrayOfNulls(size)
        }
    }
}
