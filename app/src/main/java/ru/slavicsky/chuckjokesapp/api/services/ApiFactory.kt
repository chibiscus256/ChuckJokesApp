package ru.slavicsky.chuckjokesapp.api.services

private const val BASE_URL = "https://api.icndb.com"

object ApiFactory {
    val chuckNorrisApi: ChuckNorrisApi = RetrofitFactory.retrofit(BASE_URL)
        .create(ChuckNorrisApi::class.java)
}