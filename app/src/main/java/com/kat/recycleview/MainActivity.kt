package com.kat.recycleview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.kat.recycleview.model.Club
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    private var clubs: MutableList<Club> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpRecycleview()

        initData()
    }

    private fun initData(){
        val name= resources.getStringArray(R.array.club_name)
        val desc= resources.getStringArray(R.array.club_desc)
        val imageClub  = resources.obtainTypedArray(R.array.club_image)
        clubs.clear()

        for (i in name.indices){
            clubs.add(Club(imageClub.getResourceId(i,0),name[i],desc[i]))
        }

        imageClub.recycle()
    }

    private fun setUpRecycleview(){
        clubRV.layoutManager    = LinearLayoutManager(this)
        clubRV.adapter          = ClubAdapter(this,clubs){ club ->

            startActivity<DetailClubActivity>(
                    "club" to club
            )

        }
    }
}
