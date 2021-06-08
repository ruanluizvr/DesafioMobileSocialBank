package com.ruan.desafioruanluiz.domain

import com.ruan.desafioruanluiz.domain.model.FilmeModel
import com.ruan.desafioruanluiz.repository.RepositoryImpl
import com.ruan.desafioruanluiz.repository.model.DetalhesFilme

class FilmeUseCase() {

    private val repository: RepositoryImpl

    init {
        repository = RepositoryImpl()
    }

    fun getFilmeList(name: String): List<FilmeModel> {
        val finalFilmeList = mutableListOf<FilmeModel>()
        val filmeList = repository.getFilmeList(name)

        filmeList?.Search?.forEach {
            val filmeView = FilmeModel(it.Title, it.Year, it.Poster, it.imdbID)
            finalFilmeList.add(filmeView)
        }

        return finalFilmeList
    }

    //Coloquei ?, pois se caso der erro, vai retornar null
    fun getFilmeDetalhes(cod: String): DetalhesFilme? {
        val filmeDetalhe = repository.getDetalhesFilme(cod)

        return filmeDetalhe
    }
}