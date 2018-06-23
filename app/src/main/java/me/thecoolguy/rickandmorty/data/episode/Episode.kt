package me.thecoolguy.rickandmorty.data.episode

import com.squareup.moshi.Json
import java.text.SimpleDateFormat
import java.util.*

data class Episode(
        @Json(name = "id")
        val id: Int,

        @Json(name = "url")
        val url: String,

        @Json(name = "air_date")
        val airDate: String,

        @Json(name = "characters")
        val characters: List<String>,

        @Json(name = "created")
        val created: String,

        @Json(name = "name")
        val name: String,

        @Json(name = "episode")
        val episode: String
)

fun String.toDate(): Date {
    return SimpleDateFormat("dd MMM, yyyy").parse(this)
}