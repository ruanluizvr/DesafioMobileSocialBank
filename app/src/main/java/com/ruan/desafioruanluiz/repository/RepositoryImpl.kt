package com.ruan.desafioruanluiz.repository

import com.ruan.desafioruanluiz.repository.model.BaseResponse
import com.ruan.desafioruanluiz.repository.model.DetalhesFilme
import com.ruan.desafioruanluiz.repository.retrofit.ImdbAPI
import com.ruan.desafioruanluiz.repository.retrofit.ImdbService


class RepositoryImpl {

    private val service: ImdbService

    init {
        val apiBuilder = ImdbAPI()
        val retrofit = apiBuilder.createRetrofit()
        service = apiBuilder.createImdbAPI(retrofit)
    }

    fun getFilmeList(name: String): BaseResponse? {

        val response = service.getFilmes(name).execute()

        if (response.isSuccessful) {
            val filme = response.body()

            if (filme != null) {
                return filme
            }
        }
        return null
    }

    fun getDetalhesFilme(codImdb: String): DetalhesFilme? {

        val response = service.getDetalhesFilme(codImdb).execute()

        if(response.isSuccessful){
            val detalhesFilme = response.body()

            if(detalhesFilme !=null){
                return(detalhesFilme)
            }
        }
        return null

    }
}