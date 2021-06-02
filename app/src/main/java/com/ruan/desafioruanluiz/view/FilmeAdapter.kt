package com.ruan.desafioruanluiz.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ruan.desafioruanluiz.R
import com.ruan.desafioruanluiz.domain.model.model.FilmeView
import com.ruan.desafioruanluiz.repository.model.Filme

class FilmeAdapter (
    private val responseList: List<FilmeView>,
    private val onItemClick: (FilmeView) -> Unit
        ): RecyclerView.Adapter<FilmeAdapter.FilmeHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmeHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.filme_item, parent,false)
        return FilmeHolder(view)
    }

    override fun getItemCount(): Int {
        return responseList.size
    }

    override fun onBindViewHolder(holder: FilmeHolder, position: Int) {
        holder.bind(responseList[position])
    }

    inner class FilmeHolder (itemView: View):RecyclerView.ViewHolder(itemView){
        fun bind(filme: FilmeView){
            val imageView = itemView.findViewById<ImageView>(R.id.poster)
            val titulo = itemView.findViewById<TextView>(R.id.Titulo)
            val ano = itemView.findViewById<TextView>(R.id.ano)

            titulo.text = filme.titulo
            ano.text = filme.ano.toString()

            Glide.with(itemView)
                .load(filme.poster)
                .into(imageView)

            itemView.setOnClickListener{
                onItemClick(filme)
            }
        }


    }

}