package ru.slavicsky.chuckjokesapp.models

import com.squareup.moshi.Json
import java.io.Serializable

data class GetJokesResponse(
    @field:Json(name = "value")
    val jokeResponse: MutableList<JokeResponse>
) : Serializable
