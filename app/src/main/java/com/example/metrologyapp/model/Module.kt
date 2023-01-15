package com.example.metrologyapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class Module(
    val title: String,
    val desc: String?,
    val themes: ArrayList<Theme>?
):Parcelable

