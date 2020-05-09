package com.demo.infovuz.ui.fragment.DetailPage

import android.icu.text.IDNA
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import com.demo.infovuz.R
import com.demo.infovuz.models.Info
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
       supportActionBar?.setDisplayHomeAsUpEnabled(true)
        var info: Info?=null
         info = intent.getParcelableExtra<Info>("info")
        textView_title_detail.text=info.name
        textView_discrption_detail.text=info.discriptin
        Picasso.get().load(info.image).into(imageView_detail)
        Log.d("det","$info")
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

    }

}
