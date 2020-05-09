package com.demo.infovuz.Adapter
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.demo.infovuz.models.Info
import kotlinx.android.extensions.LayoutContainer

class InfoViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView)
    , LayoutContainer {

}