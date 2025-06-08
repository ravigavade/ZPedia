package com.csaim.zpedia.data.model

data class CharacterResponse(
    val items: List<Character>
)

data class Character(
    val id: Int,
    val name: String,
    val ki: String,
    val maxKi: String,
    val race: String,
    val gender: String,
    val description: String,
    val image: String,
    val affiliation: String
)
