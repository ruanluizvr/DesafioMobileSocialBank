package com.ruan.desafioruanluiz.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.ruan.desafioruanluiz.R
import com.ruan.desafioruanluiz.presentation.DetalhesFilmeViewModel

class DetalhesFilmeActivity : AppCompatActivity() {

    private val viewModel: DetalhesFilmeViewModel by viewModels()

    lateinit var poster: ImageView
    lateinit var titulo: TextView
    lateinit var dataLancamento: TextView
    lateinit var genero: TextView
    lateinit var sinopse: TextView
    lateinit var nota: TextView
    lateinit var imgEstrela: ImageView

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
        imgEstrela = findViewById<ImageView>(R.id.imgEstrela)

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

            supportActionBar?.title = "Detalhes do Filme"
            supportActionBar?.setDisplayHomeAsUpEnabled(true)

            if (it.Year.toString() == "N/A") {
                dataLancamento.visibility = View.GONE
            } else {
                dataLancamento.text = " (" + it.Year.toString() + ")"
            }

            if (it.Genre == "N/A") {
                genero.visibility = View.GONE
            } else {
                genero.text = it.Genre
            }

            if (it.Plot == "N/A") {
                sinopse.visibility = View.GONE
            } else {
                sinopse.text = it.Plot
            }

            if (it.imdbRating == "N/A") {
                nota.visibility = View.GONE
            } else {
                imgEstrela.visibility = View.VISIBLE
                nota.text = it.imdbRating + "/10"
            }

            //verificando se é url valido
            if (Patterns.WEB_URL.matcher(it.Poster).matches()) {

                Glide.with(this)
                    .load(it.Poster)
                    .into(poster)
            }

            progressBar.visibility = View.GONE

        }
    }

    //função para observar o botão de voltar e voltar para main quando clicado
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    //objeto acessado estaticamente por outras classes
    companion object {
        val KEY_COD_FILME = "cod_filme"
    }
}