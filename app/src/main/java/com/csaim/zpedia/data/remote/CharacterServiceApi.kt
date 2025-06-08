package com.csaim.zpedia.data.remote

import com.csaim.zpedia.data.model.CharacterResponse
import retrofit2.http.GET

interface CharacterServiceApi {

    @GET("characters")
    suspend fun getCharacters(): CharacterResponse

}