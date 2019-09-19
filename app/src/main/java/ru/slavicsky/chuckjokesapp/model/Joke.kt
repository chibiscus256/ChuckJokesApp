package ru.slavicsky.chuckjokesapp.model

import com.squareup.moshi.Json
import java.io.Serializable

data class Joke(
    @field:Json(name = "jokes")
    val value: String
) : Serializable
