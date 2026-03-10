package ru.anlyashenko.moviesapp.domain

import android.os.Parcelable
import com.google.firebase.database.PropertyName
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
data class CastModel(
    @PropertyName("Actor") val actor: String = "",
    @PropertyName("PicUrl") val picUrl: String = ""
) : Parcelable
