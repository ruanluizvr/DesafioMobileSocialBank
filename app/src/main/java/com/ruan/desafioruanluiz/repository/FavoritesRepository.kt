package com.ruan.desafioruanluiz.repository

import android.content.SharedPreferences
import com.ruan.desafioruanluiz.repository.model.FilmeFavorito


class FavoritesRepository(val sharedPreferences: SharedPreferences) {

    val key = "Favorites"
    fun save(cod: String, name: String) {
        val editor = sharedPreferences.edit()
        editor.putString(cod, name)
        editor.apply()
    }


    fun delete(cod: String) {
        val editor = sharedPreferences.edit()
        editor.remove(cod)
        editor.apply()
    }

    fun getFilmes(): List<FilmeFavorito> {
        val filmes = sharedPreferences.all as MutableMap<String, String>


        var result: MutableList<FilmeFavorito> = ArrayList()
        filmes.forEach {
            result.add(FilmeFavorito(it.key, it.value))
        }

        return result
    }


}
