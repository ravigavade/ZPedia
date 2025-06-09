package com.csaim.zpedia.data.model

import coil.transform.Transformation

data class CharacterDetailsResponse(
    val name: String,
    val ki: String,
    val maxKi: String,
    val race: String,
    val gender: String,
    val description: String,
    val affiliation: String,
    val image: String,
    val originPlanet: OGplanet,
    val transformations: List<Transformations>


)

data class OGplanet(
    val name: String,
    val description: String,
    val image: String
)

data class Transformations(
    val name: String,
    val image: String,
    val ki: String
)
