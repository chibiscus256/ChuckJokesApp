package ru.slavicsky.chuckjokesapp.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.io.Serializable

data class JokesResponse(
    @Json(name = "value") val jokes: List<Joke> = listOf()
) : Serializable
