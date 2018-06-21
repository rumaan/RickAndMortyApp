package me.thecoolguy.rickandmorty.data.info

import com.squareup.moshi.Json

data class Info(

        @Json(name = "next")
        val next: String? = null,

        @Json(name = "pages")
        val pages: Int? = null,

        @Json(name = "prev")
        val prev: String? = null,

        @Json(name = "count")
        val count: Int? = null
)