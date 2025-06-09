package com.csaim.zpedia.data.remote

import com.csaim.zpedia.data.model.CharacterDetailsResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterDetailsServiceApi {

    @GET("characters/{id}")
    suspend fun getCharacterById(@Path("id") id: Int): CharacterDetailsResponse
}