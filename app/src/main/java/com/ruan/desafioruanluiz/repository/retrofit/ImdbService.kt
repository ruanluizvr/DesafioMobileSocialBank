package com.ruan.desafioruanluiz.repository.retrofit


import com.ruan.desafioruanluiz.repository.model.BaseResponse
import com.ruan.desafioruanluiz.repository.model.DetalhesFilme
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ImdbService {

    @GET(".")
    fun getFilmes(
        @Query("s") titulo: String,
        @Query("type") type: String = "movie",
        @Query("apikey") apikey: String = "31ea2554"
    ): Call<BaseResponse>

    @GET(".")
    fun getDetalhesFilme(
        @Query("i")codImdb: String,
        @Query("apikey")apikey: String = "31ea2554"
    ): Call<DetalhesFilme>


}