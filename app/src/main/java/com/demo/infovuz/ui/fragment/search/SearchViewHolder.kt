package com.demo.infovuz.ui.fragment.search

import android.content.Intent
import android.util.Log
import com.demo.infovuz.R
import com.demo.infovuz.models.Info
import com.demo.infovuz.ui.fragment.DetailPage.DetailActivity
import com.squareup.picasso.Picasso
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import kotlinx.android.synthetic.main.list_row_search.view.*


class SearchViewHolder(var  info: Info): Item<GroupieViewHolder>() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        Picasso.get().load(info.image).into(viewHolder.itemView.imageView_search)
        viewHolder.itemView.textView_name_search.text = info.name
        viewHolder.itemView.textView_dicrption_search.text=info.discriptin
        Log.d("searching","$info////////////")
        viewHolder.itemView.setOnClickListener {
            val intent = Intent( viewHolder.itemView.context, DetailActivity::class.java)
            intent.putExtra("info",info)
            viewHolder.itemView.context?.startActivity(intent)
        }
}

    override fun getLayout(): Int {
        return R.layout.list_row_search
    }


}


