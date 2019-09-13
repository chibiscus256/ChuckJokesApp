package ru.slavicsky.chuckjokesapp.models

import android.os.Parcel
import android.os.Parcelable
import com.squareup.moshi.Json
import java.io.Serializable

data class JokeResponse(
    @field:Json(name = "joke")
    val value: String
) : Serializable
