package com.ruan.desafioruanluiz.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ruan.desafioruanluiz.domain.FilmeUseCase
import com.ruan.desafioruanluiz.domain.model.model.FilmeView
import com.ruan.desafioruanluiz.repository.RepositoryImpl
import com.ruan.desafioruanluiz.repository.retrofit.ImdbAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val useCase: FilmeUseCase

    init {
        useCase = FilmeUseCase()
    }

    private val _filmeList: MutableLiveData<List<FilmeView>> = MutableLiveData()
    val filmelist: LiveData<List<FilmeView>>
        get() = _filmeList

    fun getFilmeList(name: String){

        viewModelScope.launch(Dispatchers.IO) {
            _filmeList.postValue(useCase.getFilmeList(name))
        }
    }
}