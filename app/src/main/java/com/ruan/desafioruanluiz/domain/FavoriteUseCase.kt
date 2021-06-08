package com.ruan.desafioruanluiz.domain

import android.content.SharedPreferences
import com.ruan.desafioruanluiz.repository.FavoritesRepository
import com.ruan.desafioruanluiz.repository.model.FilmeFavorito

class FavoriteUseCase (val sharedPreferences: SharedPreferences){

    val repository = FavoritesRepository(sharedPreferences)

    fun saveFavorite(cod: String, nome: String){

        repository.save(cod, nome)

    }

    fun deleteFavorite(cod: String){

        repository.delete(cod)

    }

    fun getFavoriteList(): List<FilmeFavorito> {

        return repository.getFilmes()
    }
}