package com.ruan.desafioruanluiz.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ruan.desafioruanluiz.R

class DetalhesFilme : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes_filme)


        val params = intent.extras

        val codImdb = params?.getString("cod")


    }
}