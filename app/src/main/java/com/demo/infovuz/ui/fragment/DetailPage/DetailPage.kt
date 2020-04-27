package com.demo.infovuz.ui.fragment.DetailPage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.demo.infovuz.R
import com.demo.infovuz.models.Info
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_page.*

class DetailPage : AppCompatActivity() {

    companion object {
        val INFO_KEY = "INFO_KEY"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_page)


        val image=intent.getStringExtra("image")
        val dis=intent.getStringExtra("dis")
        val title=intent.getStringExtra("title")

        val uri =image.toString()
        Picasso.get().load(uri).into(imageView_det)
        textView_name.text=title.toString()
        textView_dis.text=dis.toString()




    }
}
