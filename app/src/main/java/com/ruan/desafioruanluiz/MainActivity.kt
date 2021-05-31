package com.ruan.desafioruanluiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.ruan.desafioruanluiz.network.Repository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val bttBuscar = findViewById<Button>(R.id.bttBuscar)

        val retornoBusca = findViewById<TextView>(R.id.retornoBusca)

        retornoBusca.text = null

        val repository = Repository()

        bttBuscar.setOnClickListener {


            val chaveBusca = findViewById<EditText>(R.id.chaveBusca).text.toString()

            if (chaveBusca != "") {
                GlobalScope.launch {
                    val list = repository.getFilmeList(chaveBusca)

                    list.forEach {
                        retornoBusca.text =
                            retornoBusca.text.toString() + "Poster: " + it.Poster + "Titulo: " + it.Title + "Ano: " + it.Year + "\n"
                    }
                }
            }
        }
    }
}

