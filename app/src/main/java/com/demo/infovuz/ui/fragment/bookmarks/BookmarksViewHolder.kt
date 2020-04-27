package com.demo.infovuz.ui.fragment.bookmarks

import android.content.Intent
import android.util.Log
import com.demo.infovuz.R
import com.demo.infovuz.models.Info
import com.demo.infovuz.ui.fragment.DetailPage.DetailPage
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.squareup.picasso.Picasso
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import kotlinx.android.synthetic.main.list_row_bookmarks.view.*

class BookmarksViewHolder(
    val info: Info,
    val adapter: GroupAdapter<GroupieViewHolder>, val bookmarksInfoMap: HashMap<String, Info>): Item<GroupieViewHolder>() {
   /* override fun getLayout(): Int =R.layout.list_row_bookmarks

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        Picasso.get().load(info.image).into(viewHolder.itemView.imageView_bookmarksImage)
        viewHolder.itemView.textView_univername_bookmarks.text=info.name
       *//* viewHolder.itemView.setOnClickListener {
            val intent = Intent( viewHolder.itemView.context, DetailPage::class.java)
            intent.putExtra("image",info?.image)
            intent.putExtra("dis" ,info?.discriptin)
            intent.putExtra("title",info?.name)
            viewHolder.itemView.context?.startActivity(intent)
        }*//*
        viewHolder.itemView.delete_bookmarks_univerlist.setOnClickListener {
            viewHolder.itemView.delete_bookmarks_univerlist.playAnimation()
            //bookmarksFragment().refreshRecycleViewMessages()
        }
*/





     override fun getLayout(): Int = R.layout.list_row_bookmarks
     override fun bind(viewHolder: GroupieViewHolder, position: Int) {
         Picasso.get().load(info.image).into(viewHolder.itemView.imageView_bookmarksImage)
         viewHolder.itemView.textView_univername_bookmarks.text=info.name
         viewHolder.itemView.setOnClickListener {
             val intent = Intent( viewHolder.itemView.context, DetailPage::class.java)
             intent.putExtra("image",info?.image)
             intent.putExtra("dis" ,info?.discriptin)
             intent.putExtra("title",info?.name)
             viewHolder.itemView.context?.startActivity(intent)
         }
         viewHolder.itemView.delete_bookmarks_univerlist.setOnClickListener {
             DeleteBookmarks(viewHolder)

         }}
     private fun DeleteBookmarks( viewHolder: GroupieViewHolder) {
         val uid = FirebaseAuth.getInstance().uid ?: ""
         val ref = FirebaseDatabase.getInstance().getReference("/users/$uid/bookmarks")
         ref.child(info.name).removeValue()
         viewHolder.itemView.delete_bookmarks_univerlist.playAnimation()
         refreshRecycleViewMessages()
         ref.addChildEventListener(object : ChildEventListener{
     override fun onCancelled(p0: DatabaseError) {
     }

     override fun onChildMoved(p0: DataSnapshot, p1: String?) {


     }

     override fun onChildChanged(p0: DataSnapshot, p1: String?) {

      }

     override fun onChildAdded(p0: DataSnapshot, p1: String?) {

     }

     override fun onChildRemoved(p0: DataSnapshot) {
        //refreshRecycleViewMessages()
     }


 })}
    private fun refreshRecycleViewMessages() {
        adapter.notifyDataSetChanged()

    /*   bookmarksInfoMap.values.forEach {
           adapter.add(BookmarksViewHolder(info, adapter, bookmarksInfoMap))
           Log.d("T", "${info}-----------------------------------------------")
       }}*/
    }}









