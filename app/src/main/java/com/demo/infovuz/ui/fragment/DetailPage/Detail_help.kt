package com.demo.infovuz.ui.fragment.DetailPage

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.demo.infovuz.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.help_detail.*

class Detail_help:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
              super.onCreate(savedInstanceState)
            setContentView(R.layout.help_detail)
        supportActionBar?.title = "Help"

        val image=intent.getStringExtra("image")
        val title=intent.getStringExtra("title")
        val decryption=intent.getStringExtra("decryption")

        textView_title.text=title
        Picasso.get().load(image).into(imageView_detail)
        textView_discrption.text=decryption

    }
}