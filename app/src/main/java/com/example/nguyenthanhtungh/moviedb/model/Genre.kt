package com.example.nguyenthanhtungh.moviedb.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Genre(
        var id: String? = null,
        var name: String? = null
) : Parcelable
