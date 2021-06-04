package com.ruan.desafioruanluiz.view

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ruan.desafioruanluiz.R
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

                //sumir com teclado da tela ao clicar em buscar
                hideKeyboard(it)

                setObservers()
                viewModel.getFilmes(chaveBusca)
            }
        }
    }

    //metodo para retirar o teclado da tela (Google)
    private fun hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken,0)
    }


    private fun setObservers() {
        viewModel.filmelist.observe(this) {
            setListOnScreen(it)
        }
    }

    private fun setListOnScreen(list: List<FilmeModel>) {
        findViewById<RecyclerView>(R.id.recyclerViewFilmes).apply {
            layoutManager = GridLayoutManager(this@MainActivity, 1)

            adapter = FilmeAdapter(list) {

                val intent = Intent(this@MainActivity, DetalhesFilmeActivity::class.java).apply {
                    putExtra(DetalhesFilmeActivity.KEY_COD_FILME, it.cod)
                }
                startActivity(intent)
            }
        }
    }


}

