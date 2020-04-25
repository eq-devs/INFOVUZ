package com.demo.infovuz.ui.fragment.universities

import android.widget.Toast
import com.demo.infovuz.R
import com.demo.infovuz.models.Info
import com.squareup.picasso.Picasso
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import kotlinx.android.synthetic.main.list_row_universities.view.*

class InfoItemViewHolder( val  info: Info): Item<GroupieViewHolder>() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.textView_univer_name_detail.text=info?.name
        Picasso.get().load(info?.image).into(viewHolder.itemView.imageView_untverImage)
        viewHolder.itemView.add_bookmarks_univerlist.setOnClickListener {

            Toast.makeText(viewHolder.itemView.context,"Added", Toast.LENGTH_SHORT).show()}}
    override fun getLayout(): Int {
        return R.layout.list_row_universities

    }
}