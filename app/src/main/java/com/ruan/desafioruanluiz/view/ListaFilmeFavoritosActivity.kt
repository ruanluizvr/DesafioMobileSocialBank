package com.ruan.desafioruanluiz.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.ruan.desafioruanluiz.R
import com.ruan.desafioruanluiz.presentation.ListaFilmeFavoritosViewModel
import com.ruan.desafioruanluiz.presentation.MainViewModel

class ListaFilmeFavoritosActivity : AppCompatActivity() {


    private val listaFilmeViewModel: ListaFilmeFavoritosViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_filme_favoritos)
    }

}