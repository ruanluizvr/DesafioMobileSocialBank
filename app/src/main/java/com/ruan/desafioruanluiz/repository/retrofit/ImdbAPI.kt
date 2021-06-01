package com.ruan.desafioruanluiz.repository.retrofit

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ImdbAPI {

    private val baseurl = "http://www.omdbapi.com/"

    fun createRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(baseurl)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    fun createImdbAPI(retrofit: Retrofit): ImdbService =
        retrofit.create(ImdbService::class.java)




}