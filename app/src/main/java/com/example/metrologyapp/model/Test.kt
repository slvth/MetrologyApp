package com.example.metrologyapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
data class Test(
    val question: String,
    val trueAnswer: Int,
    val answers: ArrayList<String>
    ):Parcelable
