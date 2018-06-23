package me.thecoolguy.rickandmorty.data.episode

import com.squareup.moshi.Json
import me.thecoolguy.rickandmorty.data.info.Info

data class EpisodeResponse(

        @Json(name = "results")
        val results: List<Episode>,

        @Json(name = "info")
        val info: Info
)