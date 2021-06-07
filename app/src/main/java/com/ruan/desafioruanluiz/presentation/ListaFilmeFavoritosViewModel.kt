package com.ruan.desafioruanluiz.presentation

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ruan.desafioruanluiz.domain.FavoriteUseCase
import com.ruan.desafioruanluiz.repository.model.FilmeFavorito
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListaFilmeFavoritosViewModel(sharedPreferences: SharedPreferences):ViewModel() {
    val useCase = FavoriteUseCase()


    private val _favoriteList: MutableLiveData<List<FilmeFavorito>> = MutableLiveData()
    val favoriteList: LiveData<List<FilmeFavorito>>
        get() = _favoriteList

    fun getFavoritos(){
        viewModelScope.launch(Dispatchers.IO) {
            _favoriteList.postValue(
                useCase.getFavoriteList()
            )
        }
    }


}