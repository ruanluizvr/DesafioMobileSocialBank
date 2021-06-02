package com.ruan.desafioruanluiz.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.ruan.desafioruanluiz.R
import com.ruan.desafioruanluiz.repository.RepositoryImpl
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val bttBuscar = findViewById<Button>(R.id.bttBuscar)

        

        val retornoBusca = findViewById<TextView>(R.id.Titulo)

        retornoBusca.text = null

        val repository = RepositoryImpl()

        bttBuscar.setOnClickListener {


            val chaveBusca = findViewById<EditText>(R.id.chaveBusca).text.toString()

            if (chaveBusca != "") {
                GlobalScope.launch {
                    val response = repository.getFilmeList(chaveBusca)

                    response?.Search?.forEach {


                    }

                    val texto = response?.Search?.get(0)?.Title

                    runOnUiThread {
                        retornoBusca.text = texto
                    }
                }
            }
        }




    }
}

