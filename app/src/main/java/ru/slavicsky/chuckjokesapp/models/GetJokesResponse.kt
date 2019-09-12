package ru.slavicsky.chuckjokesapp.models

import com.squareup.moshi.Json

data class GetJokesResponse(
    @field:Json(name = "value")
    val jokeResponse: MutableList<JokeResponse>
)
