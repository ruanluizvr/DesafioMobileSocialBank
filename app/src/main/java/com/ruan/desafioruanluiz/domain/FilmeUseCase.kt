package com.ruan.desafioruanluiz.domain

import com.ruan.desafioruanluiz.domain.model.FilmeView
import com.ruan.desafioruanluiz.repository.RepositoryImpl

class FilmeUseCase(private val repository: RepositoryImpl, val name: String) {
    fun getFilmeList(): List<FilmeView>{

       val finalFilmeList = mutableListOf<FilmeView>()
       val filmelist = repository.getFilmeList(name)



    }
}