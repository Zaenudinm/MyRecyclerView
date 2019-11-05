package com.example.myrecyclerview.adapterGrid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.myrecyclerview.R
import com.example.myrecyclerview.pojo.Hero

class GridHeroAdapter (val listHeroes:ArrayList<Hero>): RecyclerView.Adapter<GridHeroAdapter.GridHeroAdapter>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridHeroAdapter {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.item_grid,parent,false)
        return GridHeroAdapter(view)
    }

    override fun getItemCount(): Int {
        return listHeroes.size
    }

    override fun onBindViewHolder(holder: GridHeroAdapter, position: Int) {
        Glide.with(holder.itemView.context)
            .load(listHeroes[position].photo)
            .apply(RequestOptions().override(350,550))
            .into(holder.imgPhoto)
    }

    inner class GridHeroAdapter(itemView:View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto:ImageView = itemView.findViewById(R.id.img_item_photos)

    }
}