package com.csaim.zpedia.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CharacterApi {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://dragonball-api.com/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val characterServiceApi = retrofit.create(CharacterServiceApi::class.java)
    var characterDetailsServiceApi = retrofit.create(CharacterDetailsServiceApi::class.java)
}