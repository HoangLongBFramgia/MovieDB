package com.example.nguyenthanhtungh.moviedb.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "genre")
class Genre(
        @PrimaryKey(autoGenerate = false)
        @SerializedName("id")
        var id: String? = null,
        @SerializedName("name")
        var name: String? = null
) : Parcelable
