package ru.slavicsky.chuckjokesapp.models

import com.squareup.moshi.Json

data class JokeResponse(
    @field:Json(name = "joke")
    val value: String
)
