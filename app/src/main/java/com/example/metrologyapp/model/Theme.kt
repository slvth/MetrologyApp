package com.example.metrologyapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
data class Theme(
    val title: String,
    val text: String,
    val imageURL: String,
    val test: ArrayList<Test>?
    ) : Parcelable
