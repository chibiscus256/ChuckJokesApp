package ru.slavicsky.chuckjokesapp.model

import com.squareup.moshi.Json
import java.io.Serializable

data class Joke(
    @Json(name = "joke")
    val value: String
) : Serializable
