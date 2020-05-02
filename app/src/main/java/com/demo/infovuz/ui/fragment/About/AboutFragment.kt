package com.demo.infovuz.ui.fragment.About

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.demo.infovuz.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_about.*

class AboutFragment : Fragment() {

    private lateinit var aboutViewModel: AboutViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        aboutViewModel =
            ViewModelProviders.of(this).get(AboutViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_about, container, false)
        //val textView: TextView = root.findViewById(R.id.text_send)
        aboutViewModel.text.observe(this, Observer {
          //  textView.text = it
        })
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Picasso.get().load("https://sun9-19.userapi.com/impf/c844418/v844418764/101e4e/skPQE7u8cis.jpg?size=200x0&quality=90&sign=bd36560ce80719a08ba1bdddd6255b79").into(imageView1)
        Picasso.get().load("https://sun9-44.userapi.com/impf/c840225/v840225435/7c7bf/KGmqQGZmjks.jpg?size=200x0&quality=90&sign=1a479cbb231c321bbc6fa24edaa7ab33").into(imageView2)
        Picasso.get().load("https://sun9-9.userapi.com/impg/c858332/v858332030/11e80f/QBqPdaD-giA.jpg?size=200x0&quality=90&sign=20c34409cd370ec3bd3c46e73eb7b122").into(imageView3)


    }



}