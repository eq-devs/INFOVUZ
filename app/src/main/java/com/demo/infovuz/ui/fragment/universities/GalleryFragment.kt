package com.demo.infovuz.ui.fragment.universities

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Picture
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.demo.infovuz.PATH
import com.demo.infovuz.R
import com.demo.infovuz.Util
import com.demo.infovuz.models.Info
import com.demo.infovuz.models.User
import com.demo.infovuz.ui.fragment.DetailPage.DetailPage
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.squareup.picasso.Picasso
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import kotlinx.android.synthetic.main.fragment_universities.*
import kotlinx.android.synthetic.main.list_row_universities.*


class GalleryFragment : Fragment() {
    private lateinit var galleryViewModel: GalleryViewModel
    val InfoRef: DatabaseReference = FirebaseDatabase.getInstance().getReference(PATH)
    var info:Info?=null
    val adapter=GroupAdapter<GroupieViewHolder>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        super.onCreate(savedInstanceState)
        retainInstance = true
        galleryViewModel =
            ViewModelProviders.of(this).get(GalleryViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_universities, container, false)
       //val textView: TextView = root.findViewById(R.id.text_gallery)
        val rec:RecyclerView=root.findViewById(R.id.recyclerView_unive_list)
        galleryViewModel.text.observe(this, Observer {
          //  textView.text = it
        })
        return root
       // return inflater.inflate(R.layout.fragment_universities, container, false)

    }




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView_unive_list.setBackgroundColor(Color.BLUE)
        recyclerView_unive_list.setHasFixedSize(true)
        recyclerView_unive_list.addItemDecoration(DividerItemDecoration(context,DividerItemDecoration.VERTICAL))
   ///recyclerView_unive_list.adapter= this.adpter
        //Log.d("d","${info?.discriptin}")
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
recyclerView_unive_list.adapter=adapter
   fetchInfo()
    }
    private fun fetchInfo(){
        InfoRef.addListenerForSingleValueEvent(object : ValueEventListener {
    override fun onDataChange(p0: DataSnapshot) {
        val adpter=GroupAdapter<GroupieViewHolder>()
        p0.children.forEach{
            info=it.getValue(Info::class.java)
            Log.d("main","$info////////////")

            if (info!=null){
                adpter.add(InfoItemViewHolder(info!!))}}
        adpter.setOnItemClickListener{item, view ->
            Toast.makeText(context,"Later....",Toast.LENGTH_SHORT).show()
        }
        recyclerView_unive_list.adapter=adpter
    }
            override fun onCancelled(p0: DatabaseError) {}
        })}


}
