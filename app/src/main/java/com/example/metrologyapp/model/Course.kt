package com.example.metrologyapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class Course(
    val title: String,
    val imageURL: String,
    val modules: ArrayList<Module>
):Parcelable
