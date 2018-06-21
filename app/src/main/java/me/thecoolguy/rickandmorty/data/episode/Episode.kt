package me.thecoolguy.rickandmorty.data.episode

import com.squareup.moshi.Json

data class Episode(

        @Json(name = "air_date")
        val airDate: String? = null,

        @Json(name = "characters")
        val characters: List<String?>? = null,

        @Json(name = "created")
        val created: String? = null,

        @Json(name = "name")
        val name: String? = null,

        @Json(name = "episode")
        val episode: String? = null,

        @Json(name = "id")
        val id: Int? = null,

        @Json(name = "url")
        val url: String? = null
)