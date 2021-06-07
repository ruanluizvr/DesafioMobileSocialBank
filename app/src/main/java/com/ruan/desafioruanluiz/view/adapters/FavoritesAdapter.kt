package com.ruan.desafioruanluiz.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ruan.desafioruanluiz.R
import com.ruan.desafioruanluiz.repository.model.FilmeFavorito

class FavoritesAdapter (

    private val responseList: List<FilmeFavorito>,
    private val onItemClick: (String) -> Unit
    ): RecyclerView.Adapter<FavoritesAdapter.FilmeFavoritoHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmeFavoritoHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.filme_favorito_item, parent,false)
            return FilmeFavoritoHolder(view)
        }

        override fun getItemCount(): Int {
            return responseList.size
        }

        override fun onBindViewHolder(holder: FilmeFavoritoHolder, position: Int) {
            holder.bind(responseList[position])
        }

        inner class FilmeFavoritoHolder (itemView: View): RecyclerView.ViewHolder(itemView){
            fun bind(favorito: FilmeFavorito){

                val titulo = itemView.findViewById<TextView>(R.id.textViewFavoriteNome)


                titulo.text = favorito.name


                itemView.setOnClickListener{
                    onItemClick(favorito.cod)
                }
            }


        }


}