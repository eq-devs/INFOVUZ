package com.demo.infovuz.ui.fragment.bookmarks

import android.content.Intent
import com.demo.infovuz.R
import com.demo.infovuz.models.Info
import com.demo.infovuz.ui.fragment.DetailPage.DetailActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.squareup.picasso.Picasso
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import kotlinx.android.synthetic.main.list_row_bookmarks.view.*


class BookmarksViewHolder(val info: Info,
val adapter: GroupAdapter<GroupieViewHolder>,
                          val bookmarksInfoMap: HashMap<String,
                                  Info>): Item<GroupieViewHolder>() {





     override fun getLayout(): Int = R.layout.list_row_bookmarks

      override fun bind(viewHolder: GroupieViewHolder, position: Int) {
         Picasso.get().load(info.image).into(viewHolder.itemView.imageView_bookmarksImage)
         viewHolder.itemView.textView_univername_bookmarks.text=info.name
         viewHolder.itemView.setOnClickListener {
             val intent = Intent( viewHolder.itemView.context, DetailActivity::class.java)
             intent.putExtra("info",info)
             viewHolder.itemView.context?.startActivity(intent)
         }
         viewHolder.itemView.delete_bookmarks_univerlist.setOnClickListener {
             DeleteBookmarks(info,viewHolder,adapter,position)
//bookmarksFragment().DeleteBookmarks(info)
         }

      }


}
     private fun DeleteBookmarks(info: Info, viewHolder: GroupieViewHolder, adapter: GroupAdapter<GroupieViewHolder>, position: Int) {
         val uid = FirebaseAuth.getInstance().uid ?: ""
         val ref = FirebaseDatabase.getInstance().getReference("/users/$uid/bookmarks")
         ref.child(info.name).removeValue()
         viewHolder.itemView.delete_bookmarks_univerlist.playAnimation()

         viewHolder.itemView.delete_bookmarks_univerlist.addAnimatorUpdateListener {
             if (it.animatedFraction == 1f) {
                 adapter.removeGroupAtAdapterPosition(position)
             }}
 }










