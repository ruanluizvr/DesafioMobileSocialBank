package com.ruan.desafioruanluiz.network

import com.ruan.desafioruanluiz.model.Filme

class Repository {

    private val service: ImdbService

    init {
        val apiBuilder = ImdbAPI()
        val retrofit = apiBuilder.createRetrofit()
        service = apiBuilder.createImdbAPI(retrofit)
    }

    fun getFilmeList(name: String): List<Filme> {
        val filmeList = mutableListOf<Filme>()


        val response = service.getFilmes(name).execute()

        if (response.isSuccessful) {
            val filme = response.body()

            if (filme != null) {
                return filme
            }


        }




        return (filmeList)
    }

}