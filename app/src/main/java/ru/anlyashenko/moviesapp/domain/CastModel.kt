package ru.anlyashenko.moviesapp.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class CastModel(
    val picUrl: String = "",
    val actor: String = "",
) : Parcelable
