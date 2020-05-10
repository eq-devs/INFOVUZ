package com.demo.infovuz.ui.fragment.DetailPage

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TabHost
import androidx.appcompat.app.AppCompatActivity
import com.demo.infovuz.R
import com.demo.infovuz.models.Info
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
@Suppress("PLUGIN_WARNING")
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
        textView_address.text=info.address
        textview_phone_number.text=info.phone
        textView_email.text=info.email



        this.call_phone.setOnClickListener {
            val callIntent: Intent = Uri.parse("tel:${info.phone}").let { number ->
                Intent(Intent.ACTION_DIAL, number)
            }
            startActivity(callIntent)
        }

        send_email.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO)
            emailIntent.data = Uri.parse("mailto:${info.email}")
            startActivity(Intent.createChooser(emailIntent, "something")) }
        more_detail.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("${info.instagram}"))
            startActivity(i)  }

        //facebook
        imageView_facebook.setOnClickListener {
            var facebookAppIntent: Intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("http://facebook.com/${info.facebook}")
                )
                startActivity(facebookAppIntent)

            Log.d("fbook","${info.facebook}")

        }
        //instagram
        imageView_insta.setOnClickListener {
            try {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("http://instagram.com/_u/" + "${info.instagram}")
                intent.setPackage("com.instagram.android")
                startActivity(intent)
            } catch (anfe: ActivityNotFoundException) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.instagram.com/${info.instagram}")
                    )
                )
            }
        }

        //map
        imageView_address.setOnClickListener {
            val gmmIntentUri =
                Uri.parse("geo:0,0?q=${info.address}")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }


        Log.d("det","$info")






        val tabs = findViewById<View>(R.id.tabhost) as TabHost
        tabs.setup()
        var spec = tabs.newTabSpec("tag1")
        spec.setContent(R.id.tab1)
        spec.setIndicator("INFO")
        tabs.addTab(spec)
        spec = tabs.newTabSpec("tag2")
        spec.setContent(R.id.tab2)
        spec.setIndicator("CONTACTS")
        tabs.addTab(spec)



    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

    }

}
