package com.demo.infovuz.ui.fragment.universities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentManager
import com.demo.infovuz.R
import com.demo.infovuz.models.Info
import com.demo.infovuz.ui.fragment.DetailPage.DetailActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.squareup.picasso.Picasso
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import kotlinx.android.synthetic.main.list_row_universities.view.*


class InfoItemViewHolder(var  info: Info): Item<GroupieViewHolder>() {
    companion object {
        val INFO_KEY: String="INFO_KEY"

    }
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        Picasso.get().load(info.image).into(viewHolder.itemView.imageView_untverImage)
        viewHolder.itemView.textView_univer_name_detail?.text = info.name
        viewHolder.itemView.add_bookmarks_univerlist.setOnClickListener {
            Addbookmarks(info,viewHolder)
           }
    viewHolder.itemView.setOnClickListener {

         val intent = Intent( viewHolder.itemView.context, DetailActivity::class.java)
        /* intent.putExtra("image",info.image)
         intent.putExtra("info",info)
         intent.putExtra("dis" ,info.discriptin)
         intent.putExtra("title",info.name)*/
         intent.putExtra("info",info)
         viewHolder.itemView.context?.startActivity(intent)
    }}

    override fun getLayout(): Int {
        return R.layout.list_row_universities
    }

    private fun Addbookmarks(info: Info, viewHolder: GroupieViewHolder) {
        val uid = FirebaseAuth.getInstance().uid ?: ""
        val ref = FirebaseDatabase.getInstance().getReference("/users/$uid/bookmarks")
        info.check=true
            ref.child(info.name).setValue(info)
            .addOnSuccessListener {
                Log.d("TAG", "Finally we saved the user to Firebase Database")
                viewHolder.itemView.add_bookmarks_univerlist.playAnimation()

                //Toast.makeText(context, "successListener", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
              //  Toast.makeText(context, "successListener", Toast.LENGTH_SHORT).show()
                Log.d("TAG", "Failed to set value to database: ${it.message}")
            }}


}


