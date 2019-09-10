package ru.slavicsky.chuckjokesapp.api.services

import ru.slavicsky.chuckjokesapp.AppConstants

object ApiFactory{
    val chuckNorrisApi : ChuckNorrisApi  = RetrofitFactory.retrofit(AppConstants.BASE_URL)
        .create(ChuckNorrisApi::class.java)
}