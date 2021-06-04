package com.ruan.desafioruanluiz.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.ruan.desafioruanluiz.R
import com.ruan.desafioruanluiz.presentation.DetalhesFilmeViewModel
import com.ruan.desafioruanluiz.repository.RepositoryImpl
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DetalhesFilmeActivity : AppCompatActivity() {

    private val viewModel: DetalhesFilmeViewModel by viewModels()

    lateinit var poster: ImageView
    lateinit var titulo: TextView
    lateinit var dataLancamento: TextView
    lateinit var genero: TextView
    lateinit var sinopse: TextView
    lateinit var nota: TextView

    lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes_filme)

        poster = findViewById<ImageView>(R.id.poster)
        titulo = findViewById<TextView>(R.id.titulo)
        dataLancamento = findViewById<TextView>(R.id.datalancamento)
        genero = findViewById<TextView>(R.id.genero)
        nota = findViewById<TextView>(R.id.nota)
        sinopse = findViewById<TextView>(R.id.sinopse)

        progressBar = findViewById<ProgressBar>(R.id.progressBar)


        val params = intent.extras
        val codImdb = params?.getString(KEY_COD_FILME)
        if (codImdb != null) {
            viewModel.getDetalhesFilme(codImdb)
        }
        setObservers()
    }

    private fun setObservers() {
        viewModel.filmeDetalhe.observe(this) {
            titulo.text = it.Title
            dataLancamento.text = it.Year.toString()

            if (it.Genre == "N/A") {
                genero.visibility = View.GONE
            } else {
                genero.text = it.Genre
            }

            sinopse.text = it.Plot
            nota.text = it.imdbRating.toString()

            if (Patterns.WEB_URL.matcher(it.Poster).matches()) {

                Glide.with(this)
                    .load(it.Poster)
                    .into(poster)
            }

            progressBar.visibility = View.GONE

        }
    }

    //objeto acessado estaticamente por outras classes
    companion object {
        val KEY_COD_FILME = "cod_filme"
    }
}