package com.ruan.desafioruanluiz.presentation

import androidx.lifecycle.ViewModel
import com.ruan.desafioruanluiz.domain.FilmeUseCase
import com.ruan.desafioruanluiz.repository.RepositoryImpl
import com.ruan.desafioruanluiz.repository.retrofit.ImdbAPI

class MainViewModel: ViewModel() {

    private val useCase: FilmeUseCase

    init {
        val apiBuilder = ImdbAPI()
        val retrofit = apiBuilder.createRetrofit()
        val retrofitService = apiBuilder.createImdbAPI(retrofit)
        val repository = RepositoryImpl()
        useCase = FilmeUseCase()
    }





}