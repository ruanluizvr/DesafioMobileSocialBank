package com.ruan.desafioruanluiz.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ruan.desafioruanluiz.domain.FilmeUseCase
import com.ruan.desafioruanluiz.repository.model.DetalhesFilme

class DetalhesFilmeViewModel {
    private val filmeUseCase: FilmeUseCase

    init {
        filmeUseCase = FilmeUseCase()
    }


    private val _filmeDetalhe : MutableLiveData<DetalhesFilme> = MutableLiveData()

    val filmeDetalhe: LiveData<DetalhesFilme>
        get() = _filmeDetalhe


    fun getDetalhesFilme (cod: String){

        filmeUseCase.getFilmeDetalhes(cod)
    }


}

