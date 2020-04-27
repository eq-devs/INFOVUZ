package com.demo.infovuz.ui.fragment.universities

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.demo.infovuz.PATH
import com.demo.infovuz.models.Info
import com.google.firebase.database.*
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
private val InfoRef: DatabaseReference = FirebaseDatabase.getInstance().getReference(PATH)
class UniverListViewModel: ViewModel() {

    //
  /*  var pontosFiltrados = MutableLiveData(mutableListOf<Info>())
    val pontoTuristico = Info()*/
    //
    private val text1 = MutableLiveData<String>().apply {
        value = "This is gallery Fragment"
        value ="List of universities"}
        val text: LiveData<String> = text1

init {
   // Log.d("zeta","${infoData.toString()})****************************")
    fetchData()

}}


 private fun fetchData(){
    InfoRef.addListenerForSingleValueEvent(object : ValueEventListener {
        override fun onDataChange(p0: DataSnapshot) {
            val adpter=GroupAdapter<GroupieViewHolder>()
            p0.children.forEach{
                Log.d("zeta","$it.toString()****************************")
                val info=it.getValue(Info::class.java)
                if (info!=null){
                    adpter.add(InfoItemViewHolder(info))}}
                adpter.setOnItemClickListener{item, view ->
             //   Toast.makeText(context,"Later....",Toast.LENGTH_SHORT).show()
            }
          // recyclerView_unive_list.adapter=adpter
        }
        override fun onCancelled(p0: DatabaseError) {}
    })}
