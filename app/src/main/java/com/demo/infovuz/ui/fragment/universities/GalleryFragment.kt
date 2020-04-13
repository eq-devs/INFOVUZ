package com.demo.infovuz.ui.fragment.universities

import android.icu.text.IDNA
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import com.demo.infovuz.PATH
import com.demo.infovuz.R
import com.demo.infovuz.models.User
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_universities.*

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
        return root

    }
    init {

        recyclerView_unive_list.setHasFixedSize(true)
        recyclerView_unive_list. addItemDecoration(DividerItemDecoration(context,DividerItemDecoration.VERTICAL))
        fetchInfo()

    }
    private fun fetchInfo(){

InfoRef.addListenerForSingleValueEvent(object : ValueEventListener {
    override fun onDataChange(p0: DataSnapshot) {
        TODO("Not yet implemented")
    }

    override fun onCancelled(p0: DatabaseError) {
        TODO("Not yet implemented")
    }

})

    }
}