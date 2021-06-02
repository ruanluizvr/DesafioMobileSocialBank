package com.ruan.desafioruanluiz.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ruan.desafioruanluiz.R
import com.ruan.desafioruanluiz.repository.retrofit.ImdbService
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DetalhesFilme : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes_filme)


        val params = intent.extras

        val codImdb = params?.getString("cod")

        GlobalScope.launch {

          val service: ImdbService



          val detalhesFilme =
        }
    }
}