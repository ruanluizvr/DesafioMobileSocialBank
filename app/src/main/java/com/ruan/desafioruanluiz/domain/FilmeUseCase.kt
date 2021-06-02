package com.ruan.desafioruanluiz.domain

import com.ruan.desafioruanluiz.domain.model.model.FilmeView
import com.ruan.desafioruanluiz.repository.RepositoryImpl
import com.ruan.desafioruanluiz.repository.model.Filme
import com.ruan.desafioruanluiz.repository.retrofit.ImdbAPI
import com.ruan.desafioruanluiz.repository.retrofit.ImdbService

class FilmeUseCase() {

    private val service: ImdbService

    init {
        val apiBuilder = ImdbAPI()
        val retrofit = apiBuilder.createRetrofit()
        service = apiBuilder.createImdbAPI(retrofit)
    }

    fun getFilmeList(name: String): List<FilmeView>{
        val finalFilmeList = mutableListOf<FilmeView>()
        val filmeList = service.getFilmes(name).execute()

        filmeList.body()?.Search?.forEach {
            val filmeView = FilmeView(it.Title,it.Year,it.Poster,it.imdbID)
            finalFilmeList.add(filmeView)
        }

        return finalFilmeList
    }
}