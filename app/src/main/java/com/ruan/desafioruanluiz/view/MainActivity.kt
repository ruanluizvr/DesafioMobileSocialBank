package com.ruan.desafioruanluiz.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.ruan.desafioruanluiz.R
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ruan.desafioruanluiz.domain.model.model.FilmeView
import com.ruan.desafioruanluiz.presentation.MainViewModel
import com.ruan.desafioruanluiz.repository.RepositoryImpl
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

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

    private fun setListOnScreen(list: List<FilmeView>) {
        findViewById<RecyclerView>(R.id.recyclerViewFilmes).apply {
            layoutManager = GridLayoutManager(this@MainActivity, 3)

            adapter = FilmeAdapter(list) {


                val intent = Intent(this@MainActivity, DetalhesFilme::class.java).apply{
                   putExtra("cod", it.cod)
                }
                startActivity(intent)





                //chamar outra tela aqui


            }
        }
    }


    private fun setObservers() {
        viewModel.filmelist.observe(this) {
            setListOnScreen(it)
        }


    }
}

