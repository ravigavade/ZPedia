package com.csaim.zpedia.data.model

data class CharacterResponse(
    val items: List<Character>
)

data class Character(
    val id: Int,
    val name: String,
    val image: String
)
