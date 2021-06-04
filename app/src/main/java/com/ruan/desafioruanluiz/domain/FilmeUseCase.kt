package com.ruan.desafioruanluiz.domain

import com.ruan.desafioruanluiz.domain.model.model.FilmeModel
import com.ruan.desafioruanluiz.repository.retrofit.ImdbAPI
import com.ruan.desafioruanluiz.repository.retrofit.ImdbService
import com.ruan.desafioruanluiz.view.DetalhesFilmeActivity

class FilmeUseCase() {

    private val service: ImdbService

    init {
        val apiBuilder = ImdbAPI()
        val retrofit = apiBuilder.createRetrofit()
        service = apiBuilder.createImdbAPI(retrofit)
    }

    fun getFilmeList(name: String): List<FilmeModel>{
        val finalFilmeList = mutableListOf<FilmeModel>()
        val filmeList = service.getFilmes(name).execute()

        filmeList.body()?.Search?.forEach {
            val filmeView = FilmeModel(it.Title,it.Year,it.Poster,it.imdbID)
            finalFilmeList.add(filmeView)
        }

        return finalFilmeList
    }

    fun getFilmeDetalhes(cod: String) {

        val filmeDetalhes = DetalhesFilmeActivity

    }
}