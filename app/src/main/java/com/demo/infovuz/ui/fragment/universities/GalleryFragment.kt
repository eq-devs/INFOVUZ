package com.demo.infovuz.ui.fragment.universities

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import com.demo.infovuz.PATH
import com.demo.infovuz.R
import com.demo.infovuz.models.Info
import com.demo.infovuz.models.User
import com.google.firebase.database.*
import com.squareup.picasso.Picasso
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import kotlinx.android.synthetic.main.fragment_universities.*
import kotlinx.android.synthetic.main.list_row_universities.view.*

class GalleryFragment : Fragment() {


    private lateinit var galleryViewModel: GalleryViewModel
    private val InfoRef: DatabaseReference = FirebaseDatabase.getInstance().getReference(PATH)

    companion object{
        val INFO_KEY="INFO_KEY"
        var currentUser: User? = null

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        galleryViewModel =
            ViewModelProviders.of(this).get(GalleryViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_universities, container, false)
        val textView: TextView = root.findViewById(R.id.text_gallery)
        galleryViewModel.text.observe(this, Observer {
            textView.text = it

        })
       /// return root
        return inflater.inflate(R.layout.fragment_universities, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView_unive_list.setBackgroundColor(Color.BLUE)
        recyclerView_unive_list.setHasFixedSize(true)
        recyclerView_unive_list.addItemDecoration(DividerItemDecoration(context,DividerItemDecoration.VERTICAL))
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        fetchInfo()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    init {}


    private fun fetchInfo(){
        InfoRef.addListenerForSingleValueEvent(object : ValueEventListener {
    override fun onDataChange(p0: DataSnapshot) {
    val adpter=GroupAdapter<GroupieViewHolder>()
        p0.children.forEach{
            Log.d("main","$it.toString()")
            val info=it.getValue(Info::class.java)
            if (info!=null){
                adpter.add(InfoItem(info))}}
        adpter.setOnItemClickListener{item, view ->
            Toast.makeText(context,"Later....",Toast.LENGTH_SHORT).show()
        }

        recyclerView_unive_list.adapter=adpter

    }
    override fun onCancelled(p0: DatabaseError) {}
})}

    class InfoItem(val info: Info): Item<GroupieViewHolder>() {
        override fun bind(viewHolder: GroupieViewHolder, position: Int) {
         viewHolder.itemView.textView_univer_name.text=info.name
            Picasso.get().load(info.image).into(viewHolder.itemView.imageView_untverImage)
            viewHolder.itemView.add_bookmarks_univerlist.setOnClickListener {
                Toast.makeText(viewHolder.itemView.context,"Added",Toast.LENGTH_SHORT).show()

            }
        }


        override fun getLayout(): Int {
            return R.layout.list_row_universities

        }
}}