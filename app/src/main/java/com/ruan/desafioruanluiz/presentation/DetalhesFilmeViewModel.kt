package com.ruan.desafioruanluiz.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ruan.desafioruanluiz.domain.FilmeUseCase
import com.ruan.desafioruanluiz.repository.model.DetalhesFilme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetalhesFilmeViewModel : ViewModel() {
    private val filmeUseCase: FilmeUseCase

    init {
        filmeUseCase = FilmeUseCase()
    }


    private val _filmeDetalhe: MutableLiveData<DetalhesFilme> = MutableLiveData()

    val filmeDetalhe: LiveData<DetalhesFilme>
        get() = _filmeDetalhe


    fun getDetalhesFilme(cod: String) {

        viewModelScope.launch(Dispatchers.IO) {
            _filmeDetalhe.postValue(filmeUseCase.getFilmeDetalhes(cod))

        }
    }

}

