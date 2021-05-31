package com.ruan.desafioruanluiz.network


import com.ruan.desafioruanluiz.model.DetalhesFilme
import com.ruan.desafioruanluiz.model.Filme
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ImdbService {

    @GET(".")
    fun getFilmes(
        @Query("s") titulo: String,
        @Query("apikey") apikey: String = "31ea2554"
    ): Call<List<Filme>>


}