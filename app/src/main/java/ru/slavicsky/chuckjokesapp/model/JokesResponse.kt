package ru.slavicsky.chuckjokesapp.model

import com.squareup.moshi.Json
import java.io.Serializable

data class JokesResponse(
    @field:Json(name = "value")
    val jokes: MutableList<Joke>
) : Serializable
