package com.demo.infovuz.ui.fragment.help

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.demo.infovuz.R
import com.demo.infovuz.ui.fragment.DetailPage.DetailPage
import com.demo.infovuz.ui.fragment.DetailPage.Detail_help
import kotlinx.android.synthetic.main.fragment_help.*

class HelpFragment : Fragment() {

    private lateinit var helpViewModel: HelpViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        helpViewModel =
            ViewModelProviders.of(this).get(HelpViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_help, container, false)
      //  val textView: TextView = root.findViewById(R.id.text_share)
        helpViewModel.text.observe(this, Observer {
        //    textView.text = it
        })
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        textView1.setOnClickListener {
            val intent = Intent( context, Detail_help::class.java)
            intent.putExtra("image","https://cdn.guidingtech.com/imager/assets/242879/delete-google-assistant-history-android-15_4d470f76dc99e18ad75087b1b8410ea9.png?1571744522")
            intent.putExtra("title","How to edit profile?")
            intent.putExtra("decryption","By tapping on the add/change photo, you can take photo, choose from library or remove profile photo.\n" +
                    " \n" +
                    "Turn on/off notifications.\n" +
                    " \n" +
                    "Change your currrent username, by writing available one.\n" +
                    " \n" +
                    "Change password, by writing new one and rewrite it.")
            context?.startActivity(intent)
        }
        textView2.setOnClickListener {
            val intent = Intent( context, Detail_help::class.java)
            intent.putExtra("image","https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcThV4Z00lNVxpbcyONpyKkFmfLbgZ3c14CAAxFpWbPD_r4MFBvw&usqp=CAU")
            intent.putExtra("title","How to edit profile?")
            intent.putExtra("decryption","By tapping on the add/change photo, you can take photo, choose from library or remove profile photo.\n" +
                    " \n" +
                    "Turn on/off notifications.\n" +
                    " \n" +
                    "Change your currrent username, by writing available one.\n" +
                    " \n" +
                    "Change password, by writing new one and rewrite it.")

            context?.startActivity(intent)
        }
        textView3.setOnClickListener {
            val intent = Intent( context, Detail_help::class.java)
            intent.putExtra("image","https://cdn.guidingtech.com/imager/assets/242879/delete-google-assistant-history-android-15_4d470f76dc99e18ad75087b1b8410ea9.png?1571744522")
            intent.putExtra("title","How to edit profile?")
            intent.putExtra("decryption","By tapping on the add/change photo, you can take photo, choose from library or remove profile photo.\n" +
                    " \n" +
                    "Turn on/off notifications.\n" +
                    " \n" +
                    "Change your currrent username, by writing available one.\n" +
                    " \n" +
                    "Change password, by writing new one and rewrite it.")
            context?.startActivity(intent)
        }
        textView4.setOnClickListener {
            val intent = Intent( context, Detail_help::class.java)
            intent.putExtra("image","https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRqkWyGfH4b7NkILV5An3h658RyL6tiADgwnMgJjyLhVZVMeYyg&usqp=CAU")
            intent.putExtra("title","How to edit profile?")
            intent.putExtra("decryption","By tapping on the add/change photo, you can take photo, choose from library or remove profile photo.\n" +
                    " \n" +
                    "Turn on/off notifications.\n" +
                    " \n" +
                    "Change your currrent username, by writing available one.\n" +
                    " \n" +
                    "Change password, by writing new one and rewrite it.")
            context?.startActivity(intent)
        }
    }

}

