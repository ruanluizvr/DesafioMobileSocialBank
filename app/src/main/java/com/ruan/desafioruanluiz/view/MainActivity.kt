package com.ruan.desafioruanluiz.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.ruan.desafioruanluiz.R
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ruan.desafioruanluiz.domain.model.model.FilmeModel
import com.ruan.desafioruanluiz.presentation.MainViewModel
import com.ruan.desafioruanluiz.view.adapters.FilmeAdapter

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bttBuscar = findViewById<Button>(R.id.bttBuscar)

        bttBuscar.setOnClickListener {

            val chaveBusca = findViewById<EditText>(R.id.chaveBusca).text.toString()

            if (chaveBusca != "") {

                setObservers()
                viewModel.getFilmeList(chaveBusca)
            }
        }
    }


    private fun setObservers() {
        viewModel.filmelist.observe(this) {
            setListOnScreen(it)
        }
    }

    private fun setListOnScreen(list: List<FilmeModel>) {
        findViewById<RecyclerView>(R.id.recyclerViewFilmes).apply {
            layoutManager = GridLayoutManager(this@MainActivity, 2)

            adapter = FilmeAdapter(list) {

                val intent = Intent(this@MainActivity, DetalhesFilmeActivity::class.java).apply {
                    putExtra(DetalhesFilmeActivity.KEY_COD_FILME, it.cod)
                }
                startActivity(intent)
            }
        }
    }


}

