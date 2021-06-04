package com.ruan.desafioruanluiz.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.ruan.desafioruanluiz.R
import com.ruan.desafioruanluiz.repository.RepositoryImpl
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DetalhesFilmeActivity : AppCompatActivity() {

//    val progressBar = findViewById<ProgressBar>(R.id.progressBar)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_detalhes_filme)

//        progressBar.visibility = View.GONE

        val params = intent.extras

        val repository = RepositoryImpl()

        val codImdb = params?.getString(KEY_COD_FILME)

        if (codImdb != null) {

            GlobalScope.launch {


                val response = repository.getDetalhesFilme(codImdb)

                runOnUiThread {

                    val poster = findViewById<ImageView>(R.id.poster)
                    val titulo = findViewById<TextView>(R.id.titulo)
                    val dataLancamento = findViewById<TextView>(R.id.datalancamento)
                    val genero = findViewById<TextView>(R.id.genero)
                    val sinopse = findViewById<TextView>(R.id.sinopse)
                    val nota = findViewById<TextView>(R.id.nota)

                    if (response != null) {
                        Glide.with(this@DetalhesFilmeActivity).load(response.Poster).into(poster)

                        titulo.text = response.Title

                        dataLancamento.text = response.Year.toString()

                        genero.text = response.Genre

                        sinopse.text = response.Plot

                        nota.text = response.imdbRating.toString()
                    }

                }


            }

        }

    }
    //objeto acessado estaticamente por outras classes
    companion object{
        val KEY_COD_FILME = "cod_filme"
    }
}