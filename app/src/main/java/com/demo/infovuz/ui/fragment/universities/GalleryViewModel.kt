package com.demo.infovuz.ui.fragment.universities

import android.text.style.TtsSpan
import android.util.Log
import android.view.AbsSavedState
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.demo.infovuz.PATH
import com.demo.infovuz.models.Info
import com.demo.infovuz.models.User
import com.google.firebase.database.*
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import kotlinx.android.synthetic.main.fragment_universities.*
import javax.xml.validation.ValidatorHandler

class GalleryViewModel : ViewModel() {

    var info: Info? = null

    private val InfoRef: DatabaseReference = FirebaseDatabase.getInstance().getReference(PATH)
    private val _text = MutableLiveData<String>().apply {
        value = "This is gallery Fragment"
    value ="List of universities"

    }
    val text: LiveData<String> = _text

    private fun fetchInfo(){
        InfoRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(p0: DataSnapshot) {
                val adpter= GroupAdapter<GroupieViewHolder>()
                p0.children.forEach{
                    Log.d("main","$it.toString()")
                    val info=it.getValue(Info::class.java)
                    if (info!=null){
                        adpter.add(GalleryFragment.InfoItem(info))}}
                adpter.setOnItemClickListener{item, view ->
                  //  Toast.makeText(context,"Later....", Toast.LENGTH_SHORT).show()
                }

             //   recyclerView_unive_list.adapter=adpter

            }
            override fun onCancelled(p0: DatabaseError) {}
        })}

}
