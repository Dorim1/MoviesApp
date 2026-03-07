package ru.anlyashenko.moviesapp.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable


@Serializable
@Parcelize
data class FilmItemModel(
    val title: String = "",
    val description: String = "",
    val post: String = "",
    val time: String = "",
    val trailer: String = "",
    val imdb: String = "",
    val year: String = "",
    val price: Double = 0.0,
    val genre: List<String> = emptyList(),
    val casts: List<String> = emptyList(),
) : Parcelable
