package com.example.myrecyclerview.adapterCard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.myrecyclerview.R
import com.example.myrecyclerview.pojo.Hero

class CardViewHeroAdapter (private val listHeroCard:ArrayList<Hero>) : RecyclerView.Adapter<CardViewHeroAdapter.CardViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_card,parent,false)
        return CardViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listHeroCard.size
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val hero = listHeroCard[position]
        Glide.with(holder.itemView.context)
            .load(hero.photo)
            .apply(RequestOptions().override(350,550))
            .into(holder.imgPhoto)
        holder.tvName.text = hero.name
        holder.tvDetail.text = hero.detail

        holder.btnFavorite.setOnClickListener {
            Toast.makeText(holder.itemView.context,"Favorite" + " " + listHeroCard[holder.adapterPosition]
                .name,Toast.LENGTH_SHORT).show()
        }
        holder.btnShare.setOnClickListener {
            Toast.makeText(holder.itemView.context,"Share" + " " + listHeroCard[holder.adapterPosition]
                .name,Toast.LENGTH_SHORT).show()
        }
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context,"Clik" + " " + listHeroCard[holder.adapterPosition]
                .name,Toast.LENGTH_SHORT).show()
        }
    }

    inner class CardViewHolder (itemView:View):RecyclerView.ViewHolder(itemView) {

        var imgPhoto:ImageView = itemView.findViewById(R.id.img_item_foto)
        var tvName:TextView = itemView.findViewById(R.id.item_card_name)
        var tvDetail:TextView = itemView.findViewById(R.id.card_detail);
        var btnFavorite:Button = itemView.findViewById(R.id.btn_set_favorite)
        var btnShare:Button = itemView.findViewById(R.id.btn_set_share)

    }
}