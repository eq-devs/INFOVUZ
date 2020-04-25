package com.demo.infovuz.ui.fragment.feedback

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.demo.infovuz.R
import kotlinx.android.synthetic.main.fragment_feedback.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_feedback, container, false)
      //  val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(this, Observer {
        //    textView.text = it
        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_feedback.setOnClickListener {


            val mailClient = Intent(Intent.ACTION_VIEW)
            mailClient.setClassName(
                "com.google.android.gm",
                "com.google.android.gm.ConversationListActivity"
            )
            startActivity(mailClient)
        }

    }


}