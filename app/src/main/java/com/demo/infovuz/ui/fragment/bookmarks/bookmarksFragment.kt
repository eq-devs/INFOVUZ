package com.demo.infovuz.ui.fragment.bookmarks

import android.content.Intent
import android.graphics.Color

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import com.demo.infovuz.R
import com.demo.infovuz.models.Info
import com.demo.infovuz.ui.fragment.DetailPage.DetailPage
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import kotlinx.android.synthetic.main.fragment_bookmarks.*

import kotlin.collections.HashMap

class bookmarksFragment : Fragment() {

    private lateinit var bookmarksViewModel: BookMarksViewModel
    var info: Info?=null
    val adapter= GroupAdapter<GroupieViewHolder>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        bookmarksViewModel = ViewModelProviders.of(this).get(BookMarksViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_bookmarks, container, false)
       // val textView: TextView = root.findViewById(R.id.text_slideshow)
        bookmarksViewModel.text.observe(this, Observer {
           // textView.text = it
        })
        return root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView_bookmarks_list.setBackgroundColor(Color.GREEN)
        recyclerView_bookmarks_list.setHasFixedSize(true)
        recyclerView_bookmarks_list.adapter=adapter


//        fetchBookmarksData()
        //val adapter=GroupAdapter<GroupieViewHolder>()
        recyclerView_bookmarks_list.addItemDecoration(DividerItemDecoration(context,DividerItemDecoration.VERTICAL))

        adapter.setOnItemClickListener { item, view ->
            Log.d("TAG","workssss")
            val intent= Intent(context,DetailPage::class.java)
            val row=item as BookmarksViewHolder
            intent.putExtra(DetailPage.INFO_KEY,row.info)
            startActivity(intent)
        }
        FetchBokkmarksInfo()
    }

    val  BookmarksInfoMap=HashMap<String,Info>()
    private fun FetchBokkmarksInfo() {
        val uid = FirebaseAuth.getInstance().uid ?: ""
        val ref = FirebaseDatabase.getInstance().getReference("/users/$uid/bookmarks")
        ref.addChildEventListener(object : ChildEventListener{
            override fun onChildAdded(p0: DataSnapshot, p1: String?) {
                val info =p0.getValue(Info::class.java) ?: return
                BookmarksInfoMap[p0.key!!]=info
                refreshRecycleViewMessages()
            }

            override fun onChildChanged(p0: DataSnapshot, p1: String?) {
                val info =p0.getValue(Info::class.java) ?: return
                BookmarksInfoMap[p0.key!!]=info
                refreshRecycleViewMessages()
            }

            override fun onCancelled(p0: DatabaseError) {
                TODO("Not yet implemented")
            }

            override fun onChildMoved(p0: DataSnapshot, p1: String?) {
               refreshRecycleViewMessages()
            }

            override fun onChildRemoved(p0: DataSnapshot) {
                refreshRecycleViewMessages()
            }
        })

    }

    private fun refreshRecycleViewMessages() {
       adapter.clear()
       BookmarksInfoMap.values.forEach{
           adapter.add(BookmarksViewHolder(it,adapter,BookmarksInfoMap))
           Log.d("T","${it}-----------------------------------------------")
       }
        }
    }

/*
    fun fetchBookmarksData() {
        val uid = FirebaseAuth.getInstance().uid ?: ""
        val ref = FirebaseDatabase.getInstance().getReference("/users/$uid/bookmarks")
        ref.addListenerForSingleValueEvent(object :ValueEventListener{
            override fun onCancelled(p0: DatabaseError) { }
            override fun onDataChange(p0: DataSnapshot) {
                p0.children.forEach {
                   info=it.getValue(Info::class.java)
                    if (info!=null){
                        val infoMap=HashMap<String,Info>()
                        adapter.add(BookmarksViewHolder(info!!,infoMap,adapter))
                            recyclerView_bookmarks_list.adapter=adapter
                        Log.d("demo","$infoMap" )
                    }
                }
            }


        })
    }
*/

