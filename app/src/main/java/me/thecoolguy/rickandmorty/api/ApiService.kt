package me.thecoolguy.rickandmorty.api

import io.reactivex.Flowable
import me.thecoolguy.rickandmorty.data.character.CharacterResponse
import me.thecoolguy.rickandmorty.data.episode.EpisodeResponse
import me.thecoolguy.rickandmorty.data.location.LocationResponse
import retrofit2.http.GET

const val BASE_URL = "https://rickandmortyapi.com/api/"

interface ApiService {
    @GET("character")
    fun getAllCharacters(): Flowable<CharacterResponse>

    @GET("episode")
    fun getAllEpisodes(): Flowable<EpisodeResponse>

    @GET("location")
    fun getAllLocations(): Flowable<LocationResponse>
}