package me.thecoolguy.rickandmorty.data.character

import com.squareup.moshi.Json

data class Character(

        @Json(name = "image")
        val image: String? = null,

        @Json(name = "gender")
        val gender: String? = null,

        @Json(name = "species")
        val species: String? = null,

        @Json(name = "created")
        val created: String? = null,

        @Json(name = "origin")
        val origin: Origin? = null,

        @Json(name = "name")
        val name: String? = null,

        @Json(name = "location")
        val location: Location? = null,

        @Json(name = "episode")
        val episode: List<String?>? = null,

        @Json(name = "id")
        val id: Int? = null,

        @Json(name = "type")
        val type: String? = null,

        @Json(name = "url")
        val url: String? = null,

        @Json(name = "status")
        val status: String? = null
)