package me.thecoolguy.rickandmorty.data.location

import com.squareup.moshi.Json


data class Location(

        @Json(name = "created")
        val created: String? = null,

        @Json(name = "name")
        val name: String? = null,

        @Json(name = "residents")
        val residents: List<String?>? = null,

        @Json(name = "id")
        val id: Int? = null,

        @Json(name = "type")
        val type: String? = null,

        @Json(name = "dimension")
        val dimension: String? = null,

        @Json(name = "url")
        val url: String? = null
)