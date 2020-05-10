package com.demo.infovuz.ui.fragment.search

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.demo.infovuz.PATH
import com.demo.infovuz.R
import com.demo.infovuz.models.Info
import com.google.firebase.database.*
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import kotlinx.android.synthetic.main.fragment_search.*
import org.jetbrains.anko.support.v4.find


class SearchFragment : Fragment() {

    private lateinit var searchViewModel: SearchViewModel
    val InfoRef: DatabaseReference = FirebaseDatabase.getInstance().getReference(PATH)
    var info:Info?=null

    lateinit var SearchEditTtext :EditText
    lateinit var RecyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        searchViewModel =
            ViewModelProviders.of(this).get(SearchViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_search, container, false)
       // val textView: TextView = root.findViewById(R.id.text_tools)
        searchViewModel.text.observe(this, Observer {
         //   textView.text = it
        })
        return root
    }

    @SuppressLint("ResourceType")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        nature.playAnimation()
        super.onActivityCreated(savedInstanceState)
        SearchEditTtext=find(R.id.searcEditText)
        RecyclerView=find(R.id.recyclerView_search)
        RecyclerView.setHasFixedSize(true)
       // RecyclerView.setBackgroundColor(Color.CYAN)
        SearchEditTtext.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                 firebaseEventSearch(s.toString())
                nature.visibility=View.GONE

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {


            }
        })

    }


    private fun firebaseEventSearch(name: String) {
        //query to search database based on text in textbox - made case insensitive
        val eventSearchQuery: Query = InfoRef.orderByChild("name").startAt(name.toUpperCase())
            .endAt(name.toLowerCase() + "uf8ff")
        eventSearchQuery.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(it: DataSnapshot) {
                nature.visibility=View.GONE
                val adapter= GroupAdapter<GroupieViewHolder>()
                /*for (eventSnapshot in it.children) {
                    val event: Event? = eventSnapshot.getValue(Event::class.java)
                    events.add(event)
                }*/
                it.children.forEach{
                    info=it.getValue(Info::class.java)
                    ///Log.d("searching","$info////////////")

                    if (info!=null){
                        adapter.add(SearchViewHolder(info!!)) }}
                recyclerView_search.adapter=adapter

                //  adapter.notifyDataSetChanged()

            }

            override fun onCancelled(databaseError: DatabaseError) {}
        })
    }
}