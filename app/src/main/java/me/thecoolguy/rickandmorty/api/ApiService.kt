package me.thecoolguy.rickandmorty.api

import io.reactivex.Flowable
import me.thecoolguy.rickandmorty.data.character.Character
import me.thecoolguy.rickandmorty.data.character.CharacterResponse
import me.thecoolguy.rickandmorty.data.episode.Episode
import me.thecoolguy.rickandmorty.data.episode.EpisodeResponse
import me.thecoolguy.rickandmorty.data.location.Location
import me.thecoolguy.rickandmorty.data.location.LocationResponse
import retrofit2.http.GET
import retrofit2.http.Path

const val BASE_URL = "https://rickandmortyapi.com/api/"

interface ApiService {
    @GET("character")
    fun getAllCharacters(): Flowable<CharacterResponse>

    @GET("episode")
    fun getAllEpisodes(): Flowable<EpisodeResponse>

    @GET("location")
    fun getAllLocations(): Flowable<LocationResponse>

    @GET("character/{id}")
    fun getCharacterWithId(@Path("id") id: Int): Flowable<Character>

    @GET("location/{id}")
    fun getLocationWithId(@Path("id") id: Int): Flowable<Location>

    @GET("episode/{id}")
    fun getEpisodeWithId(@Path("id") id: Int): Flowable<Episode>


    // TODO: add end-points for Multiple Selections ex IDs: 1,183

}