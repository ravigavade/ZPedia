package com.csaim.zpedia.data.repository

import com.csaim.zpedia.data.model.Character
import com.csaim.zpedia.data.model.CharacterResponse
import com.csaim.zpedia.data.remote.CharacterApi
import com.csaim.zpedia.data.remote.CharacterServiceApi

class CharacterRepository {

    suspend fun getCharacters(): List<Character> {
        return CharacterApi.characterServiceApi.getCharacters().items
    }

}