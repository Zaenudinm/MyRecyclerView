package com.example.myrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.appcompat.widget.DialogTitle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myrecyclerview.adapterCard.CardViewHeroAdapter
import com.example.myrecyclerview.adapterGrid.GridHeroAdapter
import com.example.myrecyclerview.adapterList.ListHeroAdapter
import com.example.myrecyclerview.dataObj.HeroesData
import com.example.myrecyclerview.pojo.Hero

class MainActivity : AppCompatActivity() {

    private lateinit var rvHeroes: RecyclerView
    private var list:ArrayList<Hero> = arrayListOf()

    private var title:String="Mode List"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setActionBarTitle(title)

        rvHeroes = findViewById(R.id.rv_heroes)
        rvHeroes.setHasFixedSize(true)

        list.addAll(HeroesData.listData)
        showRecyclerList()

        list.addAll(HeroesData.listData)
        showGrid()

        list.addAll(HeroesData.listData)
        showCard()

    }
    private fun showRecyclerList() {
        rvHeroes.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListHeroAdapter(list)
        //set Adapter
        rvHeroes.adapter = listHeroAdapter
    }
    private fun showGrid(){
        rvHeroes.layoutManager = GridLayoutManager(this,2)
        val gridHeroAdapter = GridHeroAdapter(list)
        rvHeroes.adapter = gridHeroAdapter
    }

    private fun showCard(){
        rvHeroes.layoutManager = LinearLayoutManager(this)
        val cardViewHero = CardViewHeroAdapter(list)
        rvHeroes.adapter=cardViewHero

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }
    private fun setActionBarTitle(title: String){
        if (supportActionBar != null){
            (supportActionBar as ActionBar).title = title
        }

    }

    private fun setMode(itemId: Int) {
        when (itemId){
            R.id.action_list->{
                title="List"
                showRecyclerList()

            }
            R.id.action_grid->{
                title="Grid"
                showGrid()
            }
            R.id.action_cardView->{
                title="Card"
                showCard()

            }

        }
        setActionBarTitle(title)

    }
}
