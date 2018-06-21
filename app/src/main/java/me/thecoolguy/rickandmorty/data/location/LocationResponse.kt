package me.thecoolguy.rickandmorty.data.location

import com.squareup.moshi.Json
import me.thecoolguy.rickandmorty.data.info.Info


data class LocationResponse(

        @Json(name = "results")
        val results: List<Location?>? = null,

        @Json(name = "info")
        val info: Info? = null
)