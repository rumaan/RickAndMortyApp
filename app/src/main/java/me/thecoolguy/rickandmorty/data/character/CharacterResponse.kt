package me.thecoolguy.rickandmorty.data.character

import com.squareup.moshi.Json
import me.thecoolguy.rickandmorty.data.info.Info

data class CharacterResponse(
        @Json(name = "results")
        val results: List<Character?>? = null,

        @Json(name = "info")
        val info: Info? = null
)