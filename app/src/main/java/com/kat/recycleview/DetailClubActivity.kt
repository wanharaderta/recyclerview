package com.kat.recycleview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.kat.recycleview.model.Club
import org.jetbrains.anko.*

/**
 *
 * Created by Wanhar Aderta Daeng Maro on 9/7/2018.
 * Email : wanhardaengmaro@gmail.com
 *
 */
class DetailClubActivity :AppCompatActivity(){

 //  var club: Club? = null

    lateinit var tvName:TextView
    lateinit var tvDesc:TextView
    lateinit var ImClub:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        verticalLayout {
            padding     = dip(16)
            gravity     = Gravity.CENTER_HORIZONTAL
            ImClub      = imageView(){

            }.lparams(width = 100, height = 100)
            tvName      = textView().lparams(width = wrapContent){
                topMargin   = dip(16)
            }
            tvDesc      = textView().lparams(width = matchParent){
                topMargin   = dip(16)
            }
        }

        val club = intent.getParcelableExtra<Club>("club")

        tvName.text     = club?.name
        tvDesc.text     = club?.desc
        Glide.with(this).load(club?.image).into(ImClub)
    }


}