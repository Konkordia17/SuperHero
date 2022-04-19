package com.example.superhero.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Hero(
    @Json(name = "image")
    val avatar: Image?,
    @Json(name = "name")
    val nickname: String?,
    val biography: Biography?,
    val powerstats: Powerstats?,
    val work: Work?,
    val connections: Connections?
) : Parcelable

@Parcelize
@JsonClass(generateAdapter = true)
data class Image(
    val url: String
) : Parcelable

@Parcelize
@JsonClass(generateAdapter = true)
data class Biography(
    val publisher: String,
    @Json(name = "full-name")
    val fullName: String,
    @Json(name = "place-of-birth")
    val birthsPlace: String?,
    @Json(name = "first-appearance")
    val firstAppearance: String?,

    ) : Parcelable

@Parcelize
@JsonClass(generateAdapter = true)
data class Powerstats(
    val intelligence: String?,
    val strength: String?,
    val speed: String?,
    val combat: String
) : Parcelable

@Parcelize
@JsonClass(generateAdapter = true)
data class Work(
    val occupation: String?
) : Parcelable

@Parcelize
@JsonClass(generateAdapter = true)
data class Connections(
    val relatives: String?
) : Parcelable
