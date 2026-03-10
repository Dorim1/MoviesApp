package ru.anlyashenko.moviesapp.domain

import android.os.Parcelable
import com.google.firebase.database.PropertyName
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
data class FilmItemModel(
    @PropertyName("Title") val title: String = "",
    @PropertyName("Description") val description: String = "",
    @PropertyName("Poster") val poster: String = "",
    @PropertyName("Time") val time: String = "",
    @PropertyName("Trailer") val trailer: String = "",
    @PropertyName("Imdb") val imdb: Double = 0.0,
    @PropertyName("Year") val year: Int = 0,
    @PropertyName("price") val price: Double = 0.0,
    @PropertyName("Genre") val genre: List<String> = emptyList(),
    @PropertyName("Casts") val casts: List<CastModel> = emptyList(),
) : Parcelable
